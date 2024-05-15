package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML novalidate attribute.
 * Description: This attribute indicates that the form shouldn't be validated when submitted.
 * Supported elements: <form>
 */
fun Attribute.Companion.novalidate(value: String) = add("novalidate", value)
fun List<Attribute>.novalidate(value: String) = add("novalidate", value)
