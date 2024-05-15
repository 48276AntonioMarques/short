package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML start attribute.
 * Description: Defines the first number if other than 1.
 * Supported elements: <ol>
 */
fun Attribute.Companion.start(value: String) = add("start", value)
fun List<Attribute>.start(value: String) = add("start", value)