package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML srclang attribute.
 * Description: .
 * Supported elements: <track>
 */
fun Attribute.Companion.srclang(value: String) = add("srclang", value)

/**
 * Represents the HTML srclang attribute.
 * Description: .
 * Supported elements: <track>
 */
fun List<Attribute>.srclang(value: String) = add("srclang", value)
