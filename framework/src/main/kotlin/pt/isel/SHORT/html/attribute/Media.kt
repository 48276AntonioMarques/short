package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML media attribute.
 * Description: Specifies a hint of the media for which the linked resource was designed.
 * Supported elements: < a>, <area, link>, <source, style >
 */
fun Attribute.Companion.media(value: String) = add("media", value)
fun List<Attribute>.media(value: String) = add("media", value)
