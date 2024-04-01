package pt.isel.SHORT.html

open interface Element {
    fun toHtml(): String
    fun innerHtml(): String
}
