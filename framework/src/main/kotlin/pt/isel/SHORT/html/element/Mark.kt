package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype

/**
 * Represents the HTML <mark> tag.
 * Description: Represents text which is marked or highlighted for reference or notation purposes due to the marked passage's relevance in the enclosing context.
 */
fun Tag.Mark(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("mark", attributes, content))
}
