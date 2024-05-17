package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML content attribute.
 * Description: A value associated with http-equiv or name depending on the context..
 * Supported elements: <meta>
 */
fun Attribute.Companion.content(value: String) = add("content", value)

/**
 * Represents the HTML content attribute.
 * Description: A value associated with http-equiv or name depending on the context..
 * Supported elements: <meta>
 */
fun List<Attribute>.content(value: String) = add("content", value)
