package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML default attribute.
 * Description: Indicates that the track should be enabled unless the user's preferences indicate something different.
 * Supported elements: <track>
 */
fun Attribute.Companion.default(value: String) = add("default", value)
fun List<Attribute>.default(value: String) = add("default", value)
