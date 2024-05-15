package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML wrap attribute.
 * Description: Indicates whether the text should be wrapped.
 * Supported elements: <textarea>
 */
fun Attribute.Companion.wrap(value: String) = add("wrap", value)
fun List<Attribute>.wrap(value: String) = add("wrap", value)
