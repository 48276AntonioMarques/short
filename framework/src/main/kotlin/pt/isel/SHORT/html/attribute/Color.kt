package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML color attribute.
 * Description: This attribute sets the text color using either a named color or a color specified in the hexadecimal #RRGGBB format. Note: This is a legacy attribute. Please use the CSS color property instead.
 * Supported elements: <font>, <hr>
 */
fun Attribute.Companion.color(value: String) = add("color", value)
fun List<Attribute>.color(value: String) = add("color", value)
