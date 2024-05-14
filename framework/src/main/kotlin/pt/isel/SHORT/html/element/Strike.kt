package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <strike> tag.
 * Description: Places a strikethrough (horizontal line) over text.
 */
fun Tag.Strike(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("strike", attributes, content))
}
