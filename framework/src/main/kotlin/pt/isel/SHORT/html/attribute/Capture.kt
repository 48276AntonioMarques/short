package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML capture attribute.
 * Description: From the Media Capture specification, specifies a new file can be captured..
 * Supported elements: <input>
 */
fun Attribute.Companion.capture(value: String) = add("capture", value)

/**
 * Represents the HTML capture attribute.
 * Description: From the Media Capture specification, specifies a new file can be captured..
 * Supported elements: <input>
 */
fun List<Attribute>.capture(value: String) = add("capture", value)
