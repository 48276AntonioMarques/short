package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML coords attribute.
 * Description: A set of values specifying the coordinates of the hot-spot region.
 * Supported elements: <area>
 */
fun Attribute.Companion.coords(value: String) = add("coords", value)
fun List<Attribute>.coords(value: String) = add("coords", value)
