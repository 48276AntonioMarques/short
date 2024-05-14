package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <ul> tag.
 * Description: Represents an unordered list of items, typically rendered as a bulleted list.
 */
fun Tag.Ul(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("ul", attributes, content))
}
