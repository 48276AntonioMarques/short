package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML target attribute.
 * Description:  Specifies where to open the linked document (in the case of an a element) or where to display the response received (in the case of a form element) 
 * Supported elements: < a>, <area, base>, <form >
 */
fun Attribute.Companion.target(value: String) = add("target", value)
fun List<Attribute>.target(value: String) = add("target", value)