package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML manifest attribute.
 * Description: Specifies the URL of the document's cache manifest. Note: This attribute is obsolete, use link rel="manifest" instead. 
 * Supported elements: <html>
 */
fun Attribute.Companion.manifest(value: String) = add("manifest", value)
fun List<Attribute>.manifest(value: String) = add("manifest", value)