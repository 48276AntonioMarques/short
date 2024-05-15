package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML href attribute.
 * Description: The URL of a linked resource.
 * Supported elements: < a>, <area, base>, <link >
 */
fun Attribute.Companion.href(value: String) = add("href", value)
fun List<Attribute>.href(value: String) = add("href", value)