package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype

/**
 * Represents the HTML <tr> tag.
 * Description: Defines a row of cells in a table. The row's cells can then be established using a mix of td (data cell) and th (header cell) elements.
 */
fun Tag.Tr(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("tr", attributes, scope, content))
}
