package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML title attribute.
 * Description: Text to be displayed in a tooltip when hovering over the element.
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.title(value: String) = add("title", value)
fun List<Attribute>.title(value: String) = add("title", value)
