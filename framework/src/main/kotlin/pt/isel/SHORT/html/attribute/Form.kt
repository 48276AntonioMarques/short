package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML form attribute.
 * Description: Indicates the form that is the owner of the element.
 * Supported elements: < button, fieldset, input, label, meter, object, output, progress, select, textarea >
 */
fun Attribute.Companion.form(value: String) = add("form", value)
fun List<Attribute>.form(value: String) = add("form", value)