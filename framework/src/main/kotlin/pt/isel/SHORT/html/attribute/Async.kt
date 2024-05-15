package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML async attribute.
 * Description: Executes the script asynchronously.
 * Supported elements: <script>
 */
fun Attribute.Companion.async(value: String) = add("async", value)
fun List<Attribute>.async(value: String) = add("async", value)
