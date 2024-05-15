package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML border attribute.
 * Description: The border width. Note: This is a legacy attribute. Please use the CSS border property instead.
 * Supported elements: < img>, <object, table >
 */
fun Attribute.Companion.border(value: String) = add("border", value)
fun List<Attribute>.border(value: String) = add("border", value)
