package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML draggable attribute.
 * Description: Defines whether the element can be dragged.
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.draggable(value: String) = add("draggable", value)
fun List<Attribute>.draggable(value: String) = add("draggable", value)
