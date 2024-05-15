package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML cite attribute.
 * Description: Contains a URI which points to the source of the quote or change.
 * Supported elements: < blockquote, del>, <ins, q >
 */
fun Attribute.Companion.cite(value: String) = add("cite", value)
fun List<Attribute>.cite(value: String) = add("cite", value)