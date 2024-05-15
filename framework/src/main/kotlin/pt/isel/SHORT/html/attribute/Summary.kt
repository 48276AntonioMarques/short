package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML summary attribute.
 * Description: 
 * Supported elements: <table>
 */
fun Attribute.Companion.summary(value: String) = add("summary", value)
fun List<Attribute>.summary(value: String) = add("summary", value)