package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML datetime attribute.
 * Description: Indicates the date and time associated with the element..
 * Supported elements: < del>, <ins, time >
 */
fun Attribute.Companion.datetime(value: String) = add("datetime", value)

/**
 * Represents the HTML datetime attribute.
 * Description: Indicates the date and time associated with the element..
 * Supported elements: < del>, <ins, time >
 */
fun List<Attribute>.datetime(value: String) = add("datetime", value)
