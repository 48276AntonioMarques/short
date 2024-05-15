package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML crossorigin attribute.
 * Description: How the element handles cross-origin requests
 * Supported elements: < audio>, <img, link>, <script, video >
 */
fun Attribute.Companion.crossorigin(value: String) = add("crossorigin", value)
fun List<Attribute>.crossorigin(value: String) = add("crossorigin", value)