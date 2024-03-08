package pt.isel.SHORT

import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Jetty
import org.http4k.server.asServer
import java.util.concurrent.CompletableFuture

typealias WebApp = String

fun <T : Application> runSHORT(args: Array<String>) {
    val webApp = CompletableFuture<WebApp>()

    // TODO: Allow to add more routes
    val exposedPaths = routes(
        "/" bind Method.GET to { request: Request ->
            // Maybe this should be a 404 or a static loading page
            // Until the page aggregator is finished
            if (webApp.isDone) {
                Response(Status.OK).body(webApp.get())
            } else {
                Response(Status.NOT_FOUND).body("Page not found.")
            }
        }
    )

    // TODO: Get port from environment variable or dependency injector
    val port = 9000
    // Jetty is the default servlet container (ensure this using inheritance? Or here?)
    val serverConfig = Jetty(port)

    val server = exposedPaths.asServer(serverConfig).start()
    println("Server started at port $port.")
    webApp.complete(generateWebApp())
    // TODO: Properly handle shutdown (expose server to developer?)
}