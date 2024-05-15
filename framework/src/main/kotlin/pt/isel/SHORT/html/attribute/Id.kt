package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML id attribute.
 * Description:  Often used with CSS to style a specific element. The value of this attribute must be unique. 
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.id(value: String) = add("id", value)
fun List<Attribute>.id(value: String) = add("id", value)