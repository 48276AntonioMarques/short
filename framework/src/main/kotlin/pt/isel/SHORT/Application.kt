package pt.isel.SHORT

import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.server.Jetty
import org.http4k.server.ServerConfig

typealias LoadingScreen = String
open class Application {

    fun getServerConfig(): ServerConfig = Jetty(9000)

    fun getLoadingScreen(request: Request): Response =
        Response(Status.NOT_FOUND).body("Page not found.")
}
