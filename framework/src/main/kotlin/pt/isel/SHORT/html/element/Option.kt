package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype

/**
 * Represents the HTML <option> tag.
 * Description: Used to define an item contained in a select, an optgroup, or a datalist element. As such, option can represent menu items in popups and other lists of items in an HTML document.
 */
fun Tag.Option(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("option", attributes, content))
}
