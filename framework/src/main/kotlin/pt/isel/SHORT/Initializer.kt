package pt.isel.SHORT

import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Http4kServer
import org.http4k.server.asServer
import pt.isel.SHORT.html.Html
import pt.isel.SHORT.html.HtmlPage
import pt.isel.SHORT.html.HtmlTag
import pt.isel.SHORT.html.element.Body

typealias WebApp = HtmlPage

/**
 * Top level function acting as a Kotlin shortcut allowing to write
 * `runApplication<FooApplication>(args)` instead of
 * `runApplication(FooApplication::class.java, args)`.
 */
inline fun <reified T : Application> runSHORT(args: Array<String>) {
    runSHORT(T::class.java, args)
}

/**
 * Create a new instance of [sourceManagerClass]. The context will be loaded from the overridden methods
 * The instance can have more function that will be used to inject dependencies in the pages
 */
fun <T : Application> runSHORT(sourceManagerClass: Class<T>, args: Array<String>): Http4kServer {
    // Instantiate the sources manager
    val sourceManager: T

    try {
        sourceManager = sourceManagerClass.getDeclaredConstructor().newInstance()
    } catch (e: Exception) {
        throw RuntimeException("Couldn't create an instance of the source manager", e)
    }

    // Register loading page
    val loadingPath = routes(
        "/" bind Method.GET to { request: Request ->
            var loadingScreen: HtmlTag? = null
            val root = Html {
                Body {
                    loadingScreen = sourceManager.getLoadingScreen(this)
                }
            }
            if (loadingScreen == null) {
                Response(Status(102, "Processing")).body("Server is starting.")
            } else {
                Response(Status.OK).body(root.toHtml())
            }
        }
    )

    // Launch temporary server
    val tempServer = loadingPath.asServer(sourceManager.getServerConfig()).start()

    // Generate the web app
    val webApp = generateWebApp()

    // Register new routes
    val exposedPaths = routes(
        "/" bind Method.GET to { request: Request ->
            Response(Status.OK).body(webApp.toHtml())
        }
    )

    // Stop the temporary server
    tempServer.stop()

    // Launch definitive server
    val server = exposedPaths.asServer(sourceManager.getServerConfig()).start()
    println("Server started at port ${server.port()}.")

    return server
}
