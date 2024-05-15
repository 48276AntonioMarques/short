package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML low attribute.
 * Description: Indicates the upper bound of the lower range.
 * Supported elements: <meter>
 */
fun Attribute.Companion.low(value: String) = add("low", value)
fun List<Attribute>.low(value: String) = add("low", value)
