package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML data-* attribute.
 * Description: Lets you attach custom attributes to an HTML element..
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.dataAny(value: String) = add("data-*", value)

/**
 * Represents the HTML data-* attribute.
 * Description: Lets you attach custom attributes to an HTML element..
 * Supported elements: <Global attribute>
 */
fun List<Attribute>.dataAny(value: String) = add("data-*", value)
