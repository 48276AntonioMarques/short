package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML inputmode attribute.
 * Description: Provides a hint as to the type of data that might be entered by the user while editing the element or its contents. The attribute can be used with form controls (such as the value of textarea elements), or in elements in an editing host (e.g., using contenteditable attribute).
 * Supported elements: < textarea, contenteditable >
 */
fun Attribute.Companion.inputmode(value: String) = add("inputmode", value)
fun List<Attribute>.inputmode(value: String) = add("inputmode", value)
