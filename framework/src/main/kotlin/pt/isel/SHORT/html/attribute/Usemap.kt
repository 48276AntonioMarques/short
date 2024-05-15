package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML usemap attribute.
 * Description: 
 * Supported elements: < img>, <input, object >
 */
fun Attribute.Companion.usemap(value: String) = add("usemap", value)
fun List<Attribute>.usemap(value: String) = add("usemap", value)