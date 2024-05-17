package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML readonly attribute.
 * Description: Indicates whether the element can be edited..
 * Supported elements: < input, textarea >
 */
fun Attribute.Companion.readonly(value: String) = add("readonly", value)

/**
 * Represents the HTML readonly attribute.
 * Description: Indicates whether the element can be edited..
 * Supported elements: < input, textarea >
 */
fun List<Attribute>.readonly(value: String) = add("readonly", value)
