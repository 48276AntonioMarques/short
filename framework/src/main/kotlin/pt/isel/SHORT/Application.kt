package pt.isel.SHORT

import org.http4k.server.Jetty
import org.http4k.server.ServerConfig
import pt.isel.SHORT.html.Tag

open class Application(val args: Array<String>) {

    open fun getServerConfig(): ServerConfig = Jetty(9000)

    open fun getLoadingScreen(root: Tag): Tag? = null
}
