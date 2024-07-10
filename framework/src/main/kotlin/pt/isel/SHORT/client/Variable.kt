package pt.isel.SHORT.client

import com.google.gson.GsonBuilder
import pt.isel.SHORT.html.base.element.Tag

/**
 * The proper way to create a variable.
 * This will register the variable in the global context.
 * Although it is only accessible in the scope where it is created, unless same external workarounds are used.
 */
fun <T : Any> Tag.Var(value: T) = scope.newVariable(value)

/**
 * Important: This class is meant to be used internally or when expanding the framework!!
 * Represents a variable that can be used in the client side.
 * @param id The id of the variable (meant to be used by the framework).
 * @param initialValue The initial value of the variable.
 * To create a new variable, use the [Var] function.
 */
class Variable<T>(private val id: String, private val initialValue: T) {
    internal var isUsed = false
        private set

    val reference: String // This must be an object
        get() {
            isUsed = true
            return "_SHORT_VARIABLES_['$id']"
        }

    val defaultValue: String
        get() = getDefaultValue(initialValue)

    /**
     * Converts the variable default value into a JSON string.
     */
    private fun getDefaultValue(value: T): String {
        return when (value) {
            is String -> "\"$value\""
            is Number -> value.toString()
            is Boolean -> value.toString()
            else -> GsonBuilder().create().toJson(value)
        }
    }

    /**
     * Important: This class is meant to be used internally or when expanding the framework!!
     * Represents the field of a variable.
     * This is used to access the fields of a variable, when a variable is an object.
     */
    data class Field<T>(val variable: Variable<T>, val fieldName: String)

    /**
     * Used to access the field of a variable.
     */
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
