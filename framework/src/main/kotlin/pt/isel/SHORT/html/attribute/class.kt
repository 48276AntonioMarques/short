package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

fun Attribute.Companion.`class`(value: String) = add("class", value)
fun List<Attribute>.`class`(value: String) = add("class", value)
