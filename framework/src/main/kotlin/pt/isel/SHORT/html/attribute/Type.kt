package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML type attribute.
 * Description: Defines the type of the element.
 * Supported elements: < button, input, embed, object, ol, script, source, style>, <menu, link >
 */
fun Attribute.Companion.type(value: String) = add("type", value)
fun List<Attribute>.type(value: String) = add("type", value)