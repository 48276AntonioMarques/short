package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML playsinline attribute.
 * Description: A Boolean attribute indicating that the video is to be played "inline"; that is, within the element's playback area. Note that the absence of this attribute does not imply that the video will always be played in fullscreen.
 * Supported elements: <video>
 */
fun Attribute.Companion.playsinline(value: String) = add("playsinline", value)
fun List<Attribute>.playsinline(value: String) = add("playsinline", value)
