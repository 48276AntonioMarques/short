package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML placeholder attribute.
 * Description: Provides a hint to the user of what can be entered in the field.
 * Supported elements: < input, textarea >
 */
fun Attribute.Companion.placeholder(value: String) = add("placeholder", value)
fun List<Attribute>.placeholder(value: String) = add("placeholder", value)