package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML autoplay attribute.
 * Description: The audio or video should play as soon as possible.
 * Supported elements: < audio, video >
 */
fun Attribute.Companion.autoplay(value: String) = add("autoplay", value)
fun List<Attribute>.autoplay(value: String) = add("autoplay", value)