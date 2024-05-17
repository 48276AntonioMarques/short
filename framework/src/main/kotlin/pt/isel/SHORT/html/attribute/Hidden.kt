package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML hidden attribute.
 * Description: Prevents rendering of given element, while keeping child elements, e.g. script elements, active..
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.hidden(value: String) = add("hidden", value)

/**
 * Represents the HTML hidden attribute.
 * Description: Prevents rendering of given element, while keeping child elements, e.g. script elements, active..
 * Supported elements: <Global attribute>
 */
fun List<Attribute>.hidden(value: String) = add("hidden", value)
