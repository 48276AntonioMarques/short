package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML preload attribute.
 * Description: Indicates whether the whole resource, parts of it or nothing should be preloaded.
 * Supported elements: < audio, video >
 */
fun Attribute.Companion.preload(value: String) = add("preload", value)
fun List<Attribute>.preload(value: String) = add("preload", value)
