package pt.isel.SHORT.client

import com.google.gson.Gson
import pt.isel.SHORT.html.base.Html
import pt.isel.SHORT.html.base.element.Tag

/**
 * Represents the scope where there is meant to be written javascript code.
 */
typealias JsHandler = JavaScript.() -> Unit

/**
 * Represents a Javascript scope that is not aware of the context where it is being executed.
 * This is meant to be used for debug purposes. as well as to generate code to be integrated is other scopes.
 */
class UnAwareJavaScript : JavaScript(Html { }.tag)

/**
 * Represents a Javascript scope that is aware of the context where it is being executed.
 * This is meant to be used to generate code that will be executed in the context of a tag.
 * @param tagContext the tag where the javascript code will be executed
 * This is the base class to implement javascript code.
 * This is the class to be used as receiver in the [JsHandler] type.
 * This class is the one that should be used to expand the javascript capabilities.
 */
open class JavaScript(
    private val tagContext: Tag
) {
    private val script = StringBuilder()

    /**
     * Create a representation of the browser's console global object
     */
    val console = Console(script)

    /**
     * Convert the script into an HTML string
     */
    fun toHtml(): String {
        return script.toString()
    }

    /**
     * Directly append a string to the script
     */
    fun append(string: String) {
        script.append(string)
    }

    /**
     * Set the value of a variable with a literal value (e.g. variable = event.target.value)
     */
    fun <T> literal(variable: Variable<T>, literal: String) {
        script.append("${variable.reference} = $literal;")
    }

    /**
     * Call an external function not defined in kotlin
     * (e.g. Function from a js library)
     */
    fun call(function: String, vararg args: String) {
        val argString = if (args.isNotEmpty()) {
            args.joinToString(", ") { arg -> "\"${arg}\"" }.replace("\n", "")
        } else {
            ""
        }
        script.append("$function($argString);")
    }

    /**
     * Call an external function not defined in kotlin
     * (e.g. Function from a js library)
     */
    fun call(function: String, vararg args: Variable<*>) =
        tagContext.Var(Any()).also { variable ->
            val argString = if (args.isNotEmpty()) {
                args.joinToString(", ") { arg -> arg.reference }.replace("\n", "")
            } else {
                ""
            }
            script.append("${variable.reference} = $function($argString);")
        }

    /**
     * Function to set the value of the variable
     * @param value the value to be set
     * This function will statically set the value of the variable
     */
    fun <T> set(variable: Variable<T>, value: T) {
        script.append("${variable.reference} = ${convert(value as Any)};")
    }

    /**
     * Function to set the value of the variable
     * @param value the value to be set
     * This function will set the value of the variable based on the value of another variable
     */
    fun <T> set(variable: Variable<T>, value: Variable<T>) {
        script.append("${variable.reference} = ${value.reference};")
    }

    /**
     * Function to set a field of a variable
     * @param variable the variable to be set
     * @param field the name of field to be set
     * @param value the literal value to be set
     */
    fun <T, F> update(change: Variable.Field<T>, value: F) {
        val text = if (value is Variable<*>) {
            "${change.variable.reference}.${change.fieldName} = ${value.reference};"
        } else {
            "${change.variable.reference}.${change.fieldName} = ${convert(value as Any)};"
        }
        script.append(text)
    }

    /**
     * Function that converts any type of value to a JSON string.
     */
    private fun convert(value: Any): String {
        return when (value) {
            is String -> "\"$value\""
            is Number -> value.toString()
            is Boolean -> value.toString()
            else -> Gson().toJson(value)
        }
    }
}
