package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <label> tag.
 * Description: Represents a caption for an item in a user interface.
 */
fun Tag.Label(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("label", attributes, content))
}
