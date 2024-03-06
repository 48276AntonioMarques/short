package pt.isel.SHORT

import pt.isel.SHORT.html.Html
import pt.isel.SHORT.html.element.Body
import pt.isel.SHORT.html.element.Head

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Page(val path: String)
data class PageHandler(val path: String, val page: WebPage)

typealias WebPage = String

fun generateWebApp(): WebApp {
    // Generate the base web page with client routing and server requester
    // Search for all the page notations

    val webApp = Html {
        Head {
        }
        Body {
        }
    }

    return webApp.toHtml()
}
