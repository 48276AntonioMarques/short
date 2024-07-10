package pt.isel.SHORT.html.base.element

interface Element {
    fun toHtml(): String
    fun innerHtml(): String
}
