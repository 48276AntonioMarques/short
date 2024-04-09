package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <object> tag.
 * Description: Represents an external resource, which can be treated as an image, a nested browsing context, or a resource to be handled by a plugin.
 */
fun Tag.Object(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("object", attributes, content))
}
