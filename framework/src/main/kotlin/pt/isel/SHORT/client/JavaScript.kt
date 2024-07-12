package pt.isel.SHORT.client

import com.google.gson.Gson
import pt.isel.SHORT.client.`object`.Array
import pt.isel.SHORT.client.`object`.Console
import pt.isel.SHORT.client.`object`.Event
import pt.isel.SHORT.client.`object`.Window
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
    val console = Console(this)

    /**
     * Create a representation of the browser's window global object
     */
    val window = Window(this)

    /**
     * Create a representation of event
     */
    internal val internalEvent = Event(this)

    /**
     *
     */
    val Array = Array(this)

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
     * Creates a variable that contains the property registered in the script
     */
    fun <T : Any> registerProperty(initialValue: T, literal: String): Variable<T> {
        return tagContext.Var(initialValue).also { variable ->
            if (variable.isUsed) {
                literal(variable, literal)
            }
        }
    }

    /**
     * Call an external function not defined in kotlin
     * (e.g. Function from a js library)
     */
    fun call(function: String, vararg args: Any) {
        val argString = if (args.isNotEmpty()) {
            args.joinToString(", ") { arg ->
                if (arg is Variable<*>) {
                    arg.reference
                } else {
                    convert(arg)
                }
            }.replace("\n", "")
        } else {
            ""
        }
        script.append("$function($argString);")
    }

    /**
     * Call an external function not defined in kotlin and awaits for it
     * (e.g. Function from a js library)
     */
    fun await(function: String, vararg args: Any) {
        val argString = if (args.isNotEmpty()) {
            args.joinToString(", ") { arg ->
                if (arg is Variable<*>) {
                    arg.reference
                } else {
                    convert(arg)
                }
            }.replace("\n", "")
        } else {
            ""
        }
        script.append("await $function($argString);")
    }

    /**
     * Call an eventHandler
     */
    fun call(handler: EventHandler) {
        val eventID = tagContext.scope.registerHandler(handler)
        script.append("$eventID({ target: { value: null}});")
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

    fun increment(variable: Variable<Int>) {
        script.append("${variable.reference}++;")
    }

    fun decrement(variable: Variable<Int>) {
        script.append("${variable.reference}--;")
    }

    fun concat(variable: Variable<String>, value: Variable<String>) {
        script.append("${variable.reference} += ${value.reference};")
    }

    /**
     * Function to set a field of a variable
     * @param variable the variable to be set
     * @param field the name of field to be set
     * @param value the literal value to be set
     */
    fun <T, F> setField(change: Variable.Field<T, F>, value: F) {
        script.append("${change.variable.reference}.${change.fieldName} = ${convert(value as Any)};")
    }

    /**
     * Function to set a field of a variable
     * @param variable the variable to be set
     * @param field the name of field to be set
     * @param value the variable with the value to be set
     */
    fun <T, F> setField(change: Variable.Field<T, F>, value: Variable<F>) {
        script.append("${change.variable.reference}.${change.fieldName} = ${value.reference};")
    }

    /**
     * Function to get a field of a variable
     */
    fun <T, F> getField(change: Variable.Field<T, F>, output: Variable<F>) {
        script.append("${output.reference} = ${change.variable.reference}.${change.fieldName};")
    }

    /**
     * Function that converts any type of value to a JSON string.
     */
    internal fun convert(value: Any): String {
        return when (value) {
            is String -> "\"$value\""
            is Number -> value.toString()
            is Boolean -> value.toString()
            else -> Gson().toJson(value)
        }
    }
}
