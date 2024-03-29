package pt.isel.SHORT

import org.http4k.server.Jetty
import org.http4k.server.ServerConfig
import pt.isel.SHORT.html.HtmlTag

open class Application(val args: Array<String>) {

    open fun getServerConfig(): ServerConfig = Jetty(9000)

    open fun getLoadingScreen(root: HtmlTag): HtmlTag? = null
}
