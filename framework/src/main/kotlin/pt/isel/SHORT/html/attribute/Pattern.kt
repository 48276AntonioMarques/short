package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML pattern attribute.
 * Description:  Defines a regular expression which the element's value will be validated against. 
 * Supported elements: <input>
 */
fun Attribute.Companion.pattern(value: String) = add("pattern", value)
fun List<Attribute>.pattern(value: String) = add("pattern", value)