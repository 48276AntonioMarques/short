package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML optimum attribute.
 * Description: Indicates the optimal numeric value..
 * Supported elements: <meter>
 */
fun Attribute.Companion.optimum(value: String) = add("optimum", value)

/**
 * Represents the HTML optimum attribute.
 * Description: Indicates the optimal numeric value..
 * Supported elements: <meter>
 */
fun List<Attribute>.optimum(value: String) = add("optimum", value)
