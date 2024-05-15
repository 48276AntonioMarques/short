package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML action attribute.
 * Description:  The URI of a program that processes the information submitted via the form. 
 * Supported elements: <form>
 */
fun Attribute.Companion.action(value: String) = add("action", value)
fun List<Attribute>.action(value: String) = add("action", value)