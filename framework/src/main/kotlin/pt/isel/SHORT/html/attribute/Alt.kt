package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML alt attribute.
 * Description: Alternative text in case an image can't be displayed.
 * Supported elements: < area, img>, <input >
 */
fun Attribute.Companion.alt(value: String) = add("alt", value)
fun List<Attribute>.alt(value: String) = add("alt", value)