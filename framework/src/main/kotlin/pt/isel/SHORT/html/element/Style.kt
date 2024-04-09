package pt.isel.SHORT.html.element

import pt.isel.SHORT.getResource
import pt.isel.SHORT.html.Tag

/**
 * Generates a style element with the content of the resource.
 * @param resource the name of the resource to be loaded
 * @return the current tag
 * @receiver the tag to which the style element will be appended
 * The resource will be loaded when the corresponding page is created.
 */
fun Tag.Style(resource: String) = apply {
    val content = getResource(name = resource).readText()
    appendChild(
        prototype("style") {
            Text { content }
        }
    )
}
