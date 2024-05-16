package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.prototype

/**
 * Represents the HTML <th> tag.
 * Description: A child of the tr element, it defines a cell as the header of a group of table cells. The nature of this group can be explicitly defined by the scope and headers attributes.
 */
fun Tag.Th(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("th", attributes, content))
}
