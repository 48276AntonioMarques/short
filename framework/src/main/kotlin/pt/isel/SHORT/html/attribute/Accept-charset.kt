package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML accept-charset attribute.
 * Description: List of supported charsets.
 * Supported elements: <form>
 */
fun Attribute.Companion.accept-charset(value: String) = add("accept-charset", value)
fun List<Attribute>.accept-charset(value: String) = add("accept-charset", value)