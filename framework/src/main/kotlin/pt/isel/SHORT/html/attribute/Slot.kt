package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML slot attribute.
 * Description: Assigns a slot in a shadow DOM shadow tree to an element.
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.slot(value: String) = add("slot", value)
fun List<Attribute>.slot(value: String) = add("slot", value)