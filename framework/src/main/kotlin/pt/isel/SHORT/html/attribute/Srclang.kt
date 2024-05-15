package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML srclang attribute.
 * Description: * Supported elements: <track>
 */
fun Attribute.Companion.srclang(value: String) = add("srclang", value)
fun List<Attribute>.srclang(value: String) = add("srclang", value)
