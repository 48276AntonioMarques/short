package pt.isel.SHORT

import org.http4k.server.Jetty
import org.http4k.server.ServerConfig
import pt.isel.SHORT.html.base.element.HtmlScope
import pt.isel.SHORT.html.base.element.Tag

open class Application(val args: Array<String>) {
    internal var internalScope: HtmlScope? = null

    fun getScope(): HtmlScope = internalScope ?: throw IllegalStateException("Scope not initialized")

    open fun getPort(): Int = 9000

    open fun getServerConfig(): ServerConfig = Jetty(getPort())

    open fun getLoadingScreen(root: Tag): Tag? = null
}
