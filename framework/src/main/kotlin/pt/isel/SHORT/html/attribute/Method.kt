package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML method attribute.
 * Description:  Defines which HTTP method to use when submitting the form. Can be GET (default) or POST. 
 * Supported elements: <form>
 */
fun Attribute.Companion.method(value: String) = add("method", value)
fun List<Attribute>.method(value: String) = add("method", value)