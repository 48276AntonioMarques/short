package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML maxlength attribute.
 * Description: Defines the maximum number of characters allowed in the element.
 * Supported elements: < input, textarea >
 */
fun Attribute.Companion.maxlength(value: String) = add("maxlength", value)
fun List<Attribute>.maxlength(value: String) = add("maxlength", value)
