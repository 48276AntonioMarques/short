package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML contenteditable attribute.
 * Description: Indicates whether the element's content is editable.
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.contenteditable(value: String) = add("contenteditable", value)
fun List<Attribute>.contenteditable(value: String) = add("contenteditable", value)