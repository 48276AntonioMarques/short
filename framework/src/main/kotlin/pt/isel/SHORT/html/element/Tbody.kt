package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.prototype

/**
 * Represents the HTML <tbody> tag.
 * Description: Encapsulates a set of table rows (tr elements), indicating that they comprise the body of a table's (main) data.
 */
fun Tag.Tbody(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("tbody", attributes, content))
}
