package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML high attribute.
 * Description: Indicates the lower bound of the upper range.
 * Supported elements: <meter>
 */
fun Attribute.Companion.high(value: String) = add("high", value)
fun List<Attribute>.high(value: String) = add("high", value)
