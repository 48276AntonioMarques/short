package pt.isel.SHORT.client

import pt.isel.SHORT.html.base.element.Tag

fun <T : Any> Tag.Var(value: T) = scope.newVariable(value)

class Variable<T>(private val id: String, private val initialValue: T) {
    val reference: String // This must be an object
        get() = "_SHORT_VARIABLES_['$id']"

    val defaultValue: String
        get() = getDefaultValue(initialValue)

    private fun getDefaultValue(value: T): String {
        return when (value) {
            is String -> "\"$value\""
            is Number -> value.toString()
            is Boolean -> value.toString()
            else -> value.toString() // Json.encodeToString(value)
        }
    }
}
