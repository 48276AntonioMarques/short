package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

fun Attribute.Companion.id(value: String) = add("id", value)
fun List<Attribute>.id(value: String) = add("id", value)
