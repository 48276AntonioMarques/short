package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML poster attribute.
 * Description: A URL indicating a poster frame to show until the user plays or seeks.
 * Supported elements: <video>
 */
fun Attribute.Companion.poster(value: String) = add("poster", value)
fun List<Attribute>.poster(value: String) = add("poster", value)