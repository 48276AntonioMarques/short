package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML contenteditable attribute.
 * Description: Indicates whether the element's content is editable..
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.contenteditable(value: String) = add("contenteditable", value)

/**
 * Represents the HTML contenteditable attribute.
 * Description: Indicates whether the element's content is editable..
 * Supported elements: <Global attribute>
 */
fun List<Attribute>.contenteditable(value: String) = add("contenteditable", value)
