package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML defer attribute.
 * Description: Indicates that the script should be executed after the page has been parsed.
 * Supported elements: <script>
 */
fun Attribute.Companion.defer(value: String) = add("defer", value)
fun List<Attribute>.defer(value: String) = add("defer", value)
