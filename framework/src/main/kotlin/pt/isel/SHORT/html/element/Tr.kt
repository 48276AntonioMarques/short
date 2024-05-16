package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.prototype

/**
 * Represents the HTML <tr> tag.
 * Description: Defines a row of cells in a table. The row's cells can then be established using a mix of td (data cell) and th (header cell) elements.
 */
fun Tag.Tr(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("tr", attributes, content))
}
