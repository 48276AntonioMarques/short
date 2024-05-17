package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML id attribute.
 * Description: Often used with CSS to style a specific element. The value of this attribute must be unique..
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.id(value: String) = add("id", value)

/**
 * Represents the HTML id attribute.
 * Description: Often used with CSS to style a specific element. The value of this attribute must be unique..
 * Supported elements: <Global attribute>
 */
fun List<Attribute>.id(value: String) = add("id", value)
