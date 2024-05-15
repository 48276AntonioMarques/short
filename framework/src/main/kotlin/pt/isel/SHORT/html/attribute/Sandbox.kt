package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML sandbox attribute.
 * Description:  Stops a document loaded in an iframe from using certain features (such as submitting forms or opening new windows). 
 * Supported elements: <iframe>
 */
fun Attribute.Companion.sandbox(value: String) = add("sandbox", value)
fun List<Attribute>.sandbox(value: String) = add("sandbox", value)