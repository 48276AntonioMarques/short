package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <td> tag.
 * Description: A child of the tr element, it defines a cell of a table that contains data.
 */
fun Tag.Td(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("td", attributes, content))
}
