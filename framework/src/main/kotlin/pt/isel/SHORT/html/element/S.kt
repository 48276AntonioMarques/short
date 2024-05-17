package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype

/**
 * Represents the HTML <s> tag.
 * Description: Renders text with a strikethrough, or a line through it. Use the s element to represent things that are no longer relevant or no longer accurate. However, s is not appropriate when indicating document edits; for that, use the del and ins elements, as appropriate.
 */
fun Tag.S(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("s", attributes, content))
}
