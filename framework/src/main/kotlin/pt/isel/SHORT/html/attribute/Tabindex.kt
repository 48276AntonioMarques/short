package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML tabindex attribute.
 * Description: Overrides the browser's default tab order and follows the one specified instead.
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.tabindex(value: String) = add("tabindex", value)
fun List<Attribute>.tabindex(value: String) = add("tabindex", value)
