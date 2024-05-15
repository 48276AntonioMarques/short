package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML accesskey attribute.
 * Description: Keyboard shortcut to activate or add focus to the element.
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.accesskey(value: String) = add("accesskey", value)
fun List<Attribute>.accesskey(value: String) = add("accesskey", value)