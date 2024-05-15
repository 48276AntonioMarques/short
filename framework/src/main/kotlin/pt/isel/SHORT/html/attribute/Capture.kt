package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML capture attribute.
 * Description: From the Media Capture specification, specifies a new file can be captured.
 * Supported elements: <input>
 */
fun Attribute.Companion.capture(value: String) = add("capture", value)
fun List<Attribute>.capture(value: String) = add("capture", value)
