package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML itemprop attribute.
 * Description: .
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.itemprop(value: String) = add("itemprop", value)

/**
 * Represents the HTML itemprop attribute.
 * Description: .
 * Supported elements: <Global attribute>
 */
fun List<Attribute>.itemprop(value: String) = add("itemprop", value)
