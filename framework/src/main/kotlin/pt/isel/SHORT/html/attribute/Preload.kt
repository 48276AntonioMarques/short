package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML preload attribute.
 * Description: Indicates whether the whole resource, parts of it or nothing should be preloaded..
 * Supported elements: < audio, video >
 */
fun Attribute.Companion.preload(value: String) = add("preload", value)

/**
 * Represents the HTML preload attribute.
 * Description: Indicates whether the whole resource, parts of it or nothing should be preloaded..
 * Supported elements: < audio, video >
 */
fun List<Attribute>.preload(value: String) = add("preload", value)
