package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML optimum attribute.
 * Description: Indicates the optimal numeric value.
 * Supported elements: <meter>
 */
fun Attribute.Companion.optimum(value: String) = add("optimum", value)
fun List<Attribute>.optimum(value: String) = add("optimum", value)