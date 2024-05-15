package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML srcdoc attribute.
 * Description: * Supported elements: <iframe>
 */
fun Attribute.Companion.srcdoc(value: String) = add("srcdoc", value)
fun List<Attribute>.srcdoc(value: String) = add("srcdoc", value)
