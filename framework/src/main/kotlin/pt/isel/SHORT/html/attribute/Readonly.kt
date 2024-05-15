package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML readonly attribute.
 * Description: Indicates whether the element can be edited.
 * Supported elements: < input, textarea >
 */
fun Attribute.Companion.readonly(value: String) = add("readonly", value)
fun List<Attribute>.readonly(value: String) = add("readonly", value)
