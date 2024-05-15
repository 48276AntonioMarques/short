package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML as attribute.
 * Description: Specifies the type of content being loaded by the link.
 * Supported elements: <link>
 */
fun Attribute.Companion.as(value: String) = add("as", value)
fun List<Attribute>.as(value: String) = add("as", value)