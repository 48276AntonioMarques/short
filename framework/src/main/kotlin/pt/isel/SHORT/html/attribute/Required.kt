package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML required attribute.
 * Description: Indicates whether this element is required to fill out or not.
 * Supported elements: < input, select, textarea >
 */
fun Attribute.Companion.required(value: String) = add("required", value)
fun List<Attribute>.required(value: String) = add("required", value)
