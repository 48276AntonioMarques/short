package pt.isel.SHORT.html.element

import pt.isel.SHORT.getResource
import pt.isel.SHORT.html.HtmlTag

fun HtmlTag.Style(resource: String) = apply {
    val res = getResource(name = resource)
    val content = if (res != null) {
        res.readText()
    } else {
        "console.log('Resource not found: $resource')"
    }
    appendChild(
        prototype("style") {
            Text(content)
        }
    )
}
