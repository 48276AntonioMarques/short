package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML scope attribute.
 * Description: Defines the cells that the header test (defined in the th element) relates to.
 * Supported elements: <th>
 */
fun Attribute.Companion.scope(value: String) = add("scope", value)
fun List<Attribute>.scope(value: String) = add("scope", value)
