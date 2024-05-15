package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML formaction attribute.
 * Description:  Indicates the action of the element, overriding the action defined in the form. 
 * Supported elements: < input, button >
 */
fun Attribute.Companion.formaction(value: String) = add("formaction", value)
fun List<Attribute>.formaction(value: String) = add("formaction", value)