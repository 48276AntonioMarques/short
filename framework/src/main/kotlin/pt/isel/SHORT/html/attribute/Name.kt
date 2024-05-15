package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML name attribute.
 * Description:  Name of the element. For example used by the server to identify the fields in form submits. 
 * Supported elements: < button>, <form, fieldset, iframe, input, object, output, select, textarea, map>, <meta, param >
 */
fun Attribute.Companion.name(value: String) = add("name", value)
fun List<Attribute>.name(value: String) = add("name", value)