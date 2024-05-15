package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML csp attribute.
 * Description: Specifies the Content Security Policy that an embedded document must agree to enforce upon itself.
 * Supported elements: <iframe>
 */
fun Attribute.Companion.csp(value: String) = add("csp", value)
fun List<Attribute>.csp(value: String) = add("csp", value)
