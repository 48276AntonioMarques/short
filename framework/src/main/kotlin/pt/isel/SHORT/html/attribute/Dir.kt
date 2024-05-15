package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML dir attribute.
 * Description:  Defines the text direction. Allowed values are ltr (Left-To-Right) or rtl (Right-To-Left) 
 * Supported elements: <Global attribute>
 */
fun Attribute.Companion.dir(value: String) = add("dir", value)
fun List<Attribute>.dir(value: String) = add("dir", value)