package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML allow attribute.
 * Description: Specifies a feature-policy for the iframe.
 * Supported elements: <iframe>
 */
fun Attribute.Companion.allow(value: String) = add("allow", value)
fun List<Attribute>.allow(value: String) = add("allow", value)
