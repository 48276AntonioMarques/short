package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML srcset attribute.
 * Description: One or more responsive image candidates.
 * Supported elements: <img>, <source>
 */
fun Attribute.Companion.srcset(value: String) = add("srcset", value)
fun List<Attribute>.srcset(value: String) = add("srcset", value)
