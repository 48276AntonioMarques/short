package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML integrity attribute.
 * Description: Specifies a Subresource Integrity value that allows browsers to verify what they fetch.
 * Supported elements: <link>, <script>
 */
fun Attribute.Companion.integrity(value: String) = add("integrity", value)
fun List<Attribute>.integrity(value: String) = add("integrity", value)
