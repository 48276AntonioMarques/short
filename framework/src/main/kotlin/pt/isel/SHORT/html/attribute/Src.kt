package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

fun Attribute.Companion.src(value: String) = add("src", value)
fun List<Attribute>.src(value: String) = add("src", value)
