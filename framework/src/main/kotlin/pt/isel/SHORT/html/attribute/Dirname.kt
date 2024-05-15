package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML dirname attribute.
 * Description: * Supported elements: < input, textarea >
 */
fun Attribute.Companion.dirname(value: String) = add("dirname", value)
fun List<Attribute>.dirname(value: String) = add("dirname", value)
