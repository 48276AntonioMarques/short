package pt.isel.SHORT.client

/**
 * Important: This class is meant to be used internally or when expanding the framework!!
 * Represents a switch statement.
 * @param a The variable to be compared.
 */
class Switch<T>(private val a: Variable<T>) {
    private val script = StringBuilder()

    /**
     * Converts the switch statement to a string that can be injected into the script tag.
     */
    fun toHtml(): String {
        return "switch(${a.reference}) {$script}"
    }

    /**
     * This function will add a case to the switch statement
     */
    private fun onCase(value: T, asBreak: Boolean, onCase: JsHandler) {
        val context = UnAwareJavaScript()
        context.onCase()
        val breakString = if (asBreak) "break;" else ""
        val wrappedValue = when (value) {
            is String -> "\"$value\""
            is Number -> value.toString()
            is Boolean -> value.toString()
            else -> value.toString()
        }
        script.append("case $wrappedValue: ${context.toHtml()}$breakString")
    }

    /**
     * This function will add a case to the switch statement
     * @param value the value to be compared
     * @param case the code to be executed if the value is equal to the case
     */
    fun case(value: T, case: JsHandler) = onCase(value, true, case)

    /**
     * This function will add a case to the switch statement
     * The difference between this function and the case function is that this function will not add a break statement
     * @param value the value to be compared
     * @param case the code to be executed if the value is equal to the case
     */
    fun caseContinuous(value: T, case: JsHandler) = onCase(value, false, case)

    /**
     * This function will add a default case to the switch statement
     */
    fun default(onDefault: JsHandler) {
        val context = UnAwareJavaScript()
        context.onDefault()
        script.append("default: ${context.toHtml()}")
    }
}

/**
 * Used to create a switch statement.
 * This function will be run on the client side.
 */
fun <T> JavaScript.switch(a: Variable<T>, onSwitch: Switch<T>.() -> Unit) {
    val switch = Switch(a).also { it.onSwitch() }
    append(switch.toHtml())
}
