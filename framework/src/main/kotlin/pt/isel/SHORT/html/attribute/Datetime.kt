package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML datetime attribute.
 * Description: Indicates the date and time associated with the element.
 * Supported elements: < del>, <ins, time >
 */
fun Attribute.Companion.datetime(value: String) = add("datetime", value)
fun List<Attribute>.datetime(value: String) = add("datetime", value)