package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML shape attribute.
 * Description: 
 * Supported elements: <a>, <area>
 */
fun Attribute.Companion.shape(value: String) = add("shape", value)
fun List<Attribute>.shape(value: String) = add("shape", value)