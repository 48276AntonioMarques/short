package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML as attribute.
 * Description: Specifies the type of content being loaded by the link..
 * Supported elements: <link>
 */
fun Attribute.Companion.`as`(value: String) = add("as", value)

/**
 * Represents the HTML as attribute.
 * Description: Specifies the type of content being loaded by the link..
 * Supported elements: <link>
 */
fun List<Attribute>.`as`(value: String) = add("as", value)
