package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML minlength attribute.
 * Description: Defines the minimum number of characters allowed in the element.
 * Supported elements: < input, textarea >
 */
fun Attribute.Companion.minlength(value: String) = add("minlength", value)
fun List<Attribute>.minlength(value: String) = add("minlength", value)