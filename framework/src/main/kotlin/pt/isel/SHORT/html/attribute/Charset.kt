package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML charset attribute.
 * Description: Declares the character encoding of the page or script.
 * Supported elements: <meta>
 */
fun Attribute.Companion.charset(value: String) = add("charset", value)
fun List<Attribute>.charset(value: String) = add("charset", value)