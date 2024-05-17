package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML high attribute.
 * Description: Indicates the lower bound of the upper range..
 * Supported elements: <meter>
 */
fun Attribute.Companion.high(value: String) = add("high", value)

/**
 * Represents the HTML high attribute.
 * Description: Indicates the lower bound of the upper range..
 * Supported elements: <meter>
 */
fun List<Attribute>.high(value: String) = add("high", value)
