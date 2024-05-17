package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML autocomplete attribute.
 * Description: Indicates whether controls in this form can by default have their values automatically completed by the browser..
 * Supported elements: < form>, <input, select, textarea >
 */
fun Attribute.Companion.autocomplete(value: String) = add("autocomplete", value)

/**
 * Represents the HTML autocomplete attribute.
 * Description: Indicates whether controls in this form can by default have their values automatically completed by the browser..
 * Supported elements: < form>, <input, select, textarea >
 */
fun List<Attribute>.autocomplete(value: String) = add("autocomplete", value)
