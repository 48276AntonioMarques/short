package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML rel attribute.
 * Description: Specifies the relationship of the target object to the link object..
 * Supported elements: < a>, <area, link >
 */
fun Attribute.Companion.rel(value: String) = add("rel", value)

/**
 * Represents the HTML rel attribute.
 * Description: Specifies the relationship of the target object to the link object..
 * Supported elements: < a>, <area, link >
 */
fun List<Attribute>.rel(value: String) = add("rel", value)
