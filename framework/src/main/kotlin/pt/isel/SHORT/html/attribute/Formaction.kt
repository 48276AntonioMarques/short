package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML formaction attribute.
 * Description: Indicates the action of the element, overriding the action defined in the form..
 * Supported elements: < input, button >
 */
fun Attribute.Companion.formaction(value: String) = add("formaction", value)

/**
 * Represents the HTML formaction attribute.
 * Description: Indicates the action of the element, overriding the action defined in the form..
 * Supported elements: < input, button >
 */
fun List<Attribute>.formaction(value: String) = add("formaction", value)
