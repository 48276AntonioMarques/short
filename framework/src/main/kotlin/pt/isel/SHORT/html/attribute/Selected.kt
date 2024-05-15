package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML selected attribute.
 * Description: Defines a value which will be selected on page load.
 * Supported elements: <option>
 */
fun Attribute.Companion.selected(value: String) = add("selected", value)
fun List<Attribute>.selected(value: String) = add("selected", value)