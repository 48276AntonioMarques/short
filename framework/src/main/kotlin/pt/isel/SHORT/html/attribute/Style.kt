package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML style attribute.
 * Description: Defines CSS styles which will override styles previously set.
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.style(value: String) = add("style", value)
fun List<Attribute>.style(value: String) = add("style", value)