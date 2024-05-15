package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML sizes attribute.
 * Description: 
 * Supported elements: < link>, <img, source >
 */
fun Attribute.Companion.sizes(value: String) = add("sizes", value)
fun List<Attribute>.sizes(value: String) = add("sizes", value)