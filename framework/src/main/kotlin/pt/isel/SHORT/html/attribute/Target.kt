package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML target attribute.
 * Description: Specifies where to open the linked document (in the case of an a element) or where to display the response received (in the case of a form element).
 * Supported elements: < a>, <area, base>, <form >
 */
fun Attribute.Companion.target(value: String) = add("target", value)

/**
 * Represents the HTML target attribute.
 * Description: Specifies where to open the linked document (in the case of an a element) or where to display the response received (in the case of a form element).
 * Supported elements: < a>, <area, base>, <form >
 */
fun List<Attribute>.target(value: String) = add("target", value)
