package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML hreflang attribute.
 * Description: Specifies the language of the linked resource.
 * Supported elements: <a>, <link>
 */
fun Attribute.Companion.hreflang(value: String) = add("hreflang", value)
fun List<Attribute>.hreflang(value: String) = add("hreflang", value)
