package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML checked attribute.
 * Description: Indicates whether the element should be checked on page load.
 * Supported elements: <input>
 */
fun Attribute.Companion.checked(value: String) = add("checked", value)
fun List<Attribute>.checked(value: String) = add("checked", value)