package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML loop attribute.
 * Description:  Indicates whether the media should start playing from the start when it's finished. 
 * Supported elements: < audio, marquee, video >
 */
fun Attribute.Companion.loop(value: String) = add("loop", value)
fun List<Attribute>.loop(value: String) = add("loop", value)