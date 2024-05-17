package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML loop attribute.
 * Description: Indicates whether the media should start playing from the start when it's finished..
 * Supported elements: < audio, marquee, video >
 */
fun Attribute.Companion.loop(value: String) = add("loop", value)

/**
 * Represents the HTML loop attribute.
 * Description: Indicates whether the media should start playing from the start when it's finished..
 * Supported elements: < audio, marquee, video >
 */
fun List<Attribute>.loop(value: String) = add("loop", value)
