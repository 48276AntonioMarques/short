package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML class attribute.
 * Description: Often used with CSS to style elements with common properties..
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.`class`(value: String) = add("class", value)

/**
 * Represents the HTML class attribute.
 * Description: Often used with CSS to style elements with common properties..
 * Supported elements: <Global attribute>
 */
fun List<Attribute>.`class`(value: String) = add("class", value)
