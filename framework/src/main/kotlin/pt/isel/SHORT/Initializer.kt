package pt.isel.SHORT

import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Http4kServer
import org.http4k.server.asServer
import java.util.concurrent.CompletableFuture

typealias WebApp = String

/**
 * Top level function acting as a Kotlin shortcut allowing to write
 * `runApplication<FooApplication>(args)` instead of
 * `runApplication(FooApplication::class.java, args)`.
 */
inline fun <reified T : Application> runSHORT(args: Array<String>) {
    runSHORT(T::class.java, args)
}

/**
 * Create a new instance of [sources]. The context will be loaded from the overridden methods
 * The instance can have more function that will be used to inject dependencies in the pages
 */
fun <T : Application> runSHORT(sources: Class<T>, args: Array<String>): Http4kServer {
    val serverSources: T

    try {
        serverSources = sources.getDeclaredConstructor().newInstance()
    } catch (e: Exception) {
        throw RuntimeException("Couldn't create an instance of the server sources", e)
    }

    val webApp = CompletableFuture<WebApp>()

    // TODO: Allow to add more routes
    val exposedPaths = routes(
        "/" bind Method.GET to { request: Request ->
            // Maybe this should be a 404 or a static loading page
            // Until the page aggregator is finished
            if (webApp.isDone) {
                Response(Status.OK).body(webApp.get())
            } else {
                serverSources.getLoadingScreen(request)
            }
        }
    )

    val server = exposedPaths.asServer(serverSources.getServerConfig()).start()
    println("Server started at port ${server.port()}.")

    webApp.complete(generateWebApp())

    return server
}
