package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML bgcolor attribute.
 * Description:  Background color of the element. Note: This is a legacy attribute. Please use the CSS background-color property instead. 
 * Supported elements: < body>, <col, colgroup, marquee, table, tbody, tfoot>, <td, th>, <tr >
 */
fun Attribute.Companion.bgcolor(value: String) = add("bgcolor", value)
fun List<Attribute>.bgcolor(value: String) = add("bgcolor", value)