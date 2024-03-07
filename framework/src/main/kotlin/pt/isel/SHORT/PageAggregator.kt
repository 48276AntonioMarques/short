package pt.isel.SHORT

import pt.isel.SHORT.html.Html
import pt.isel.SHORT.html.HtmlPage
import pt.isel.SHORT.html.HtmlTag
import pt.isel.SHORT.html.Script
import pt.isel.SHORT.html.element.Body
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Head

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Page(val path: String)

typealias PageFactory = () -> HtmlTag

fun generateWebApp(): WebApp {
    // Generate the base web page with client routing and server requester
    // Search for all the page notations

    val webApp = aggregatePages(getPages())
    return webApp.toHtml()
}

fun getPages(): List<PageFactory> {
    val pages = mutableListOf<PageFactory>()
    return pages
}

fun aggregatePages(pages: List<PageFactory>): HtmlPage {
    return Html {
        Head {
        }
        Script("/router.js")
        Script {
            "console.log('Hello World')"
        }
        Body {
            Div(id = "app") {
            }
        }
    }
}
