package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML kind attribute.
 * Description: Specifies the kind of text track.
 * Supported elements: <track>
 */
fun Attribute.Companion.kind(value: String) = add("kind", value)
fun List<Attribute>.kind(value: String) = add("kind", value)
