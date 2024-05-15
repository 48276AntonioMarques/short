package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML data attribute.
 * Description: Specifies the URL of the resource.
 * Supported elements: <object>
 */
fun Attribute.Companion.data(value: String) = add("data", value)
fun List<Attribute>.data(value: String) = add("data", value)