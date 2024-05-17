package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML playsinline attribute.
 * Description: A Boolean attribute indicating that the video is to be played "inline"; that is, within the element's playback area. Note that the absence of this attribute does not imply that the video will always be played in fullscreen..
 * Supported elements: <video>
 */
fun Attribute.Companion.playsinline(value: String) = add("playsinline", value)

/**
 * Represents the HTML playsinline attribute.
 * Description: A Boolean attribute indicating that the video is to be played "inline"; that is, within the element's playback area. Note that the absence of this attribute does not imply that the video will always be played in fullscreen..
 * Supported elements: <video>
 */
fun List<Attribute>.playsinline(value: String) = add("playsinline", value)
