package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.prototype

/**
 * Represents the HTML <em> tag.
 * Description: Marks text that has stress emphasis. The em element can be nested, with each nesting level indicating a greater degree of emphasis.
 */
fun Tag.Em(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("em", attributes, content))
}
