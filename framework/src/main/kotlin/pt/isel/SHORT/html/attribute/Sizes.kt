package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML sizes attribute.
 * Description: .
 * Supported elements: < link>, <img, source >
 */
fun Attribute.Companion.sizes(value: String) = add("sizes", value)

/**
 * Represents the HTML sizes attribute.
 * Description: .
 * Supported elements: < link>, <img, source >
 */
fun List<Attribute>.sizes(value: String) = add("sizes", value)
