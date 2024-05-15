package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML rows attribute.
 * Description: Defines the number of rows in a text area.
 * Supported elements: <textarea>
 */
fun Attribute.Companion.rows(value: String) = add("rows", value)
fun List<Attribute>.rows(value: String) = add("rows", value)
