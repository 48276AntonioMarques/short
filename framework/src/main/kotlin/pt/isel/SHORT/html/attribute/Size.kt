package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML size attribute.
 * Description: Defines the width of the element (in pixels). If the element's type attribute is text or password then it's the number of characters..
 * Supported elements: < input, select >
 */
fun Attribute.Companion.size(value: String) = add("size", value)

/**
 * Represents the HTML size attribute.
 * Description: Defines the width of the element (in pixels). If the element's type attribute is text or password then it's the number of characters..
 * Supported elements: < input, select >
 */
fun List<Attribute>.size(value: String) = add("size", value)
