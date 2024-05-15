package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML src attribute.
 * Description: The URL of the embeddable content.
 * Supported elements: < audio, embed, iframe>, <img, input, script, source, track, video >
 */
fun Attribute.Companion.src(value: String) = add("src", value)
fun List<Attribute>.src(value: String) = add("src", value)