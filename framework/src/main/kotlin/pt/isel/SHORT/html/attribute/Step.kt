package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML step attribute.
 * Description: .
 * Supported elements: <input>
 */
fun Attribute.Companion.step(value: String) = add("step", value)

/**
 * Represents the HTML step attribute.
 * Description: .
 * Supported elements: <input>
 */
fun List<Attribute>.step(value: String) = add("step", value)
