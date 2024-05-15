package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML controls attribute.
 * Description: Indicates whether the browser should show playback controls to the user.
 * Supported elements: < audio, video >
 */
fun Attribute.Companion.controls(value: String) = add("controls", value)
fun List<Attribute>.controls(value: String) = add("controls", value)
