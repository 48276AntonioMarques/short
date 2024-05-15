package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML min attribute.
 * Description: Indicates the minimum value allowed.
 * Supported elements: < input, meter >
 */
fun Attribute.Companion.min(value: String) = add("min", value)
fun List<Attribute>.min(value: String) = add("min", value)
