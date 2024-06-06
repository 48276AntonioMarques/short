package pt.isel.SHORT.client

typealias JsHandler = JavaScript.() -> Unit

open class JavaScript {
    private val script = StringBuilder()

    val console = Console(script)

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
        val argString = if (args.isNotEmpty()) "\"${args.joinToString("\", |")}\"" else ""
        script.append("$function($argString);")
    }

    /**
     * Convert the script into an HTML string
     */
    fun toHtml(): String {
        return script.toString()
    }

    /**
     * Function to set the value of the variable
     * @param value the value to be set
     * This function will statically set the value of the variable
     */
    fun <T> set(variable: Variable<T>, value: T) {
        val newValue = when (value) {
            is String -> "\"$value\""
            is Number -> value.toString()
            is Boolean -> value.toString()
            else -> value.toString()
        }
        script.append("${variable.reference} = $newValue;")
    }

    /**
     * Function to set the value of the variable
     * @param value the value to be set
     * This function will set the value of the variable based on the value of another variable
     */
    fun <T> set(variable: Variable<T>, value: Variable<T>) {
        script.append("${variable.reference} = ${value.reference};")
    }
}
