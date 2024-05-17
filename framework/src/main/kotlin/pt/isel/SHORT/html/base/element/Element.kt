package pt.isel.SHORT.html.base.element

open interface Element {
    fun toHtml(): String
    fun innerHtml(): String
}
