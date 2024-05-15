package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML spellcheck attribute.
 * Description: Indicates whether spell checking is allowed for the element.
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.spellcheck(value: String) = add("spellcheck", value)
fun List<Attribute>.spellcheck(value: String) = add("spellcheck", value)