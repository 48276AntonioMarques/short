package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML for attribute.
 * Description: Describes elements which belongs to this one.
 * Supported elements: < label, output >
 */
fun Attribute.Companion.`for`(value: String) = add("for", value)
fun List<Attribute>.`for`(value: String) = add("for", value)
