package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML span attribute.
 * Description: * Supported elements: < col, colgroup >
 */
fun Attribute.Companion.span(value: String) = add("span", value)
fun List<Attribute>.span(value: String) = add("span", value)
