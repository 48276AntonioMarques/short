package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML title attribute.
 * Description: Text to be displayed in a tooltip when hovering over the element..
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.title(value: String) = add("title", value)

/**
 * Represents the HTML title attribute.
 * Description: Text to be displayed in a tooltip when hovering over the element..
 * Supported elements: <Global attribute>
 */
fun List<Attribute>.title(value: String) = add("title", value)
