package pt.isel.SHORT.client

/**
 * Important: This class is meant to be used internally or when expanding the framework!!
 * Represents a loop that will be executed while the condition is true.
 * @param condition The condition to be evaluated.
 * @param block The block of code to be executed.
 */
class Loop<T>(private val condition: Condition<T>, private val block: JsHandler) {
    /**
     * Converts the loop to a string that can be injected into the script tag.
     */
    fun toHtml(): String {
        val context = UnAwareJavaScript()
        context.block()
        return "while (${condition.toHtml()}){${context.toHtml()}};"
    }
}

/**
 * The equivalent to a while loop in javascript.
 * This function will be run on the client side.
 * @param condition The condition to be evaluated.
 * @param block The block of code to be executed.
 */
fun <T> JavaScript.during(condition: Condition<T>, block: JsHandler) {
    val loop = Loop(condition, block)
    append(loop.toHtml())
}
