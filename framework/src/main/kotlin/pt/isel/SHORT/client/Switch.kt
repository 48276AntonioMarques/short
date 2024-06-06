package pt.isel.SHORT.client

class Switch<T>(private val a: Variable<T>) {
    private val script = StringBuilder()

    fun toHtml(): String {
        return "switch(${a.reference}) {$script}"
    }

    fun onCase(value: T, asBreak: Boolean, onCase: JsHandler) {
        val context = JavaScript()
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

    fun default(onDefault: JsHandler) {
        val context = JavaScript()
        context.onDefault()
        script.append("default: ${context.toHtml()}")
    }
}

fun <T> JavaScript.switch(a: Variable<T>, onSwitch: Switch<T>.() -> Unit) {
    val switch = Switch(a).also { it.onSwitch() }
    append(switch.toHtml())
}
