package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML itemprop attribute.
 * Description: 
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.itemprop(value: String) = add("itemprop", value)
fun List<Attribute>.itemprop(value: String) = add("itemprop", value)