package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML download attribute.
 * Description: Indicates that the hyperlink is to be used for downloading a resource.
 * Supported elements: <a>, <area>
 */
fun Attribute.Companion.download(value: String) = add("download", value)
fun List<Attribute>.download(value: String) = add("download", value)
