package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML step attribute.
 * Description: 
 * Supported elements: <input>
 */
fun Attribute.Companion.step(value: String) = add("step", value)
fun List<Attribute>.step(value: String) = add("step", value)