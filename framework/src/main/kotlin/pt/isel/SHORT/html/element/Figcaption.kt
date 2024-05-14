package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <figcaption> tag.
 * Description: Represents a caption or legend describing the rest of the contents of its parent figure element.
 */
fun Tag.Figcaption(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("figcaption", attributes, content))
}
