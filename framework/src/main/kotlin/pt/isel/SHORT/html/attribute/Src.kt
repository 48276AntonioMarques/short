package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML src attribute.
 * Description: The URL of the embeddable content..
 * Supported elements: < audio, embed, iframe>, <img, input, script, source, track, video >
 */
fun Attribute.Companion.src(value: String) = add("src", value)

/**
 * Represents the HTML src attribute.
 * Description: The URL of the embeddable content..
 * Supported elements: < audio, embed, iframe>, <img, input, script, source, track, video >
 */
fun List<Attribute>.src(value: String) = add("src", value)
