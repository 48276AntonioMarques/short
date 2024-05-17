package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML slot attribute.
 * Description: Assigns a slot in a shadow DOM shadow tree to an element..
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.slot(value: String) = add("slot", value)

/**
 * Represents the HTML slot attribute.
 * Description: Assigns a slot in a shadow DOM shadow tree to an element..
 * Supported elements: <Global attribute>
 */
fun List<Attribute>.slot(value: String) = add("slot", value)
