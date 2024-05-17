package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML autocapitalize attribute.
 * Description: Sets whether input is automatically capitalized when entered by user.
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.autocapitalize(value: String) = add("autocapitalize", value)

/**
 * Represents the HTML autocapitalize attribute.
 * Description: Sets whether input is automatically capitalized when entered by user.
 * Supported elements: <Global attribute>
 */
fun List<Attribute>.autocapitalize(value: String) = add("autocapitalize", value)
