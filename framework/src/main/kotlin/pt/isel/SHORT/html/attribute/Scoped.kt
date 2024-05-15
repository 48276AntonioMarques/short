package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML scoped attribute.
 * Description: 
 * Supported elements: <style>
 */
fun Attribute.Companion.scoped(value: String) = add("scoped", value)
fun List<Attribute>.scoped(value: String) = add("scoped", value)