package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML role attribute.
 * Description: Defines an explicit role for an element for use by assistive technologies.
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.role(value: String) = add("role", value)
fun List<Attribute>.role(value: String) = add("role", value)