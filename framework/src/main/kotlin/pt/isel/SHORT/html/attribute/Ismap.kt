package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML ismap attribute.
 * Description: Indicates that the image is part of a server-side image map.
 * Supported elements: <img>
 */
fun Attribute.Companion.ismap(value: String) = add("ismap", value)
fun List<Attribute>.ismap(value: String) = add("ismap", value)
