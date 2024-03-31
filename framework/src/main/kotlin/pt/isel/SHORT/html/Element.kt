package pt.isel.SHORT.html

sealed interface Element {
    fun toHtml(): String
}
