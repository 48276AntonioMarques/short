package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML checked attribute.
 * Description: Indicates whether the element should be checked on page load..
 * Supported elements: <input>
 */
fun Attribute.Companion.checked(value: String) = add("checked", value)

/**
 * Represents the HTML checked attribute.
 * Description: Indicates whether the element should be checked on page load..
 * Supported elements: <input>
 */
fun List<Attribute>.checked(value: String) = add("checked", value)
