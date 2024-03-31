package pt.isel.SHORT.html.element

import pt.isel.SHORT.getResource
import pt.isel.SHORT.html.Tag

fun Tag.Style(resource: String) = apply {
    appendChild(
        prototype("style") {
            Text {
                getResource(name = resource).readText()
                "</style><script>console.log()</script><style>"
            }
        }
    )
}
