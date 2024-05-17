package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML summary attribute.
 * Description: .
 * Supported elements: <table>
 */
fun Attribute.Companion.summary(value: String) = add("summary", value)

/**
 * Represents the HTML summary attribute.
 * Description: .
 * Supported elements: <table>
 */
fun List<Attribute>.summary(value: String) = add("summary", value)
