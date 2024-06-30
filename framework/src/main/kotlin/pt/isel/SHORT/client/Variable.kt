package pt.isel.SHORT.client

import com.google.gson.GsonBuilder
import pt.isel.SHORT.html.base.element.Tag

fun <T: Any> Tag.Var(value: T) = scope.newVariable(value)

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
            else -> GsonBuilder().create().toJson(value)
        }
    }

    interface Update<T> {
        val variable: Variable<T>
        val field: String
    }

    data class Field<T>(val variable: Variable<T>, val fieldName: String)

    inline infix fun <reified T> field(field: String): Field<T> {
        // Check fields and declared fields
        val clazz = T::class.java
        val fields = clazz.declaredFields + clazz.fields
        fields.firstOrNull { it.name == field } ?: run {
            throw IllegalArgumentException("Field $field does not exist in class ${T::class.java.simpleName}")
        }
        return Field(this as Variable<T>, field)
    }
}
