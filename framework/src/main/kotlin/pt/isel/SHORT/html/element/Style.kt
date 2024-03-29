package pt.isel.SHORT.html.element

import pt.isel.SHORT.getResource
import pt.isel.SHORT.html.HtmlTag

fun HtmlTag.Style(resource: String) = apply {
    appendChild(
        prototype("style") {
            Text {
                val res = getResource(name = resource)
                if (res != null) {
                    res.readText()
                } else {
                    "/* Resource not found: $resource */"
                }
            }
        }
    )
}
