package pt.isel.SHORT.html

import pt.isel.SHORT.JavaScriptException

class Attribute(val name: String, val value: String) {

    companion object {
        fun add(name: String, value: String) = listOf(Attribute(name, value))
    }

    fun toHtml() = "$name=\"$value\""
}

fun List<Attribute>.add(name: String, value: String) = this + Attribute(name, value)

fun List<Attribute>.toHtml(): String {
    return this.mapNotNull { attribute ->
        try {
            attribute.toHtml()
        } catch (jse: JavaScriptException) {
            // TODO: Log error on client
            null
        }
    }.joinToString(" ")
}
