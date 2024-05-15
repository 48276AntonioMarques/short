package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML headers attribute.
 * Description:  IDs of the th elements which applies to this element. 
 * Supported elements: <td>, <th>
 */
fun Attribute.Companion.headers(value: String) = add("headers", value)
fun List<Attribute>.headers(value: String) = add("headers", value)