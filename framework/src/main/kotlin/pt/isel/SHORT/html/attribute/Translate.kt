package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML translate attribute.
 * Description:  Specify whether an element's attribute values and the values of its Text node children are to be translated when the page is localized, or whether to leave them unchanged. 
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.translate(value: String) = add("translate", value)
fun List<Attribute>.translate(value: String) = add("translate", value)