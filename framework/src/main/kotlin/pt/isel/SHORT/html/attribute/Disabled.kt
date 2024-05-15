package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML disabled attribute.
 * Description: Indicates whether the user can interact with the element.
 * Supported elements: < button, fieldset, input, optgroup, option, select, textarea >
 */
fun Attribute.Companion.disabled(value: String) = add("disabled", value)
fun List<Attribute>.disabled(value: String) = add("disabled", value)
