package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML name attribute.
 * Description: Name of the element. For example used by the server to identify the fields in form submits..
 * Supported elements: < button>, <form, fieldset, iframe, input, object, output, select, textarea, map>, <meta, param >
 */
fun Attribute.Companion.name(value: String) = add("name", value)

/**
 * Represents the HTML name attribute.
 * Description: Name of the element. For example used by the server to identify the fields in form submits..
 * Supported elements: < button>, <form, fieldset, iframe, input, object, output, select, textarea, map>, <meta, param >
 */
fun List<Attribute>.name(value: String) = add("name", value)
