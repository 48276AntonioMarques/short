package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML placeholder attribute.
 * Description: Provides a hint to the user of what can be entered in the field..
 * Supported elements: < input, textarea >
 */
fun Attribute.Companion.placeholder(value: String) = add("placeholder", value)

/**
 * Represents the HTML placeholder attribute.
 * Description: Provides a hint to the user of what can be entered in the field..
 * Supported elements: < input, textarea >
 */
fun List<Attribute>.placeholder(value: String) = add("placeholder", value)
