package pt.isel.SHORT.client

/**
 * Important: This class is meant to be used internally or when expanding the framework!!
 * Represents a comparison between two variables.
 * @param condition The condition to be compared.
 * @param onSuccess The handler to be executed if the condition is true.
 * @param onFailure The handler to be executed if the condition is false.
 */
class Comparison<T>(private val condition: Condition<T>, private val onSuccess: JsHandler, private val onFailure: JsHandler? = null) {

    /**
     * The resulting string that will be injected.
     */
    private val script = StringBuilder()

    /**
     * Converts the comparison to a string that can be injected into the script tag.
     */
    fun toHtml(): String {
        val success = UnAwareJavaScript()
        success.onSuccess()
        script.append("if(${condition.toHtml()})")
        script.append("{${success.toHtml()}}")
        if (onFailure != null) {
            val failure = UnAwareJavaScript()
            onFailure.let { onFailure -> failure.onFailure() }
            script.append("else {${failure.toHtml()}}")
        }
        return script.toString()
    }

    /**
     * Responsible for adding a handler to execute when the condition evaluated is not met.
     * @param onFailure The handler to be executed if the condition is false.
     * @return The comparison object containing the condition and both handlers.
     */
    infix fun otherwise(onFailure: JsHandler) = Comparison(condition, onSuccess, onFailure)
}

/**
 * Used to compare two variables.
 * This function will be run on the client side.
 */
fun <T> JavaScript.compare(comparison: Comparison<T>): Comparison<T> {
    append(comparison.toHtml())
    return comparison
}

/**
 * Important: This enum class is meant to be used internally or when expanding the framework!!
 * Represents the type of comparison to be made.
 */
enum class ConditionType(val html: String) {
    EQUAL("=="),
    NOT_EQUAL("!="),
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUAL(">="),
    LESS_THAN("<"),
    LESS_THAN_OR_EQUAL("<="),
    STRICT_EQUAL("==="),
    STRICT_NOT_EQUAL("!==");
}

/**
 * Important: This class is meant to be used internally or when expanding the framework!!
 * Represents a condition to be compared.
 * @param a The first variable to be compared.
 * @param b The second variable to be compared.
 * @param comparison The type of comparison to be made.
 */
class Condition<T>(private val a: Variable<T>, private val b: Variable<T>, private val comparison: ConditionType) {
    /**
     * Converts the condition to a string that can be injected into the script tag.
     */
    fun toHtml(): String {
        return "${a.reference} ${comparison.html} ${b.reference}"
    }

    /**
     * Responsible for adding a handler to execute when the condition evaluated is met.
     */
    infix fun then(onSuccess: JsHandler): Comparison<T> {
        return Comparison(this, onSuccess)
    }
}

/**
 * keyword used to compare two variables. e.g. "var1 equal var2 then { ... }"
 * equivalent to "var1 == var2"
 */
infix fun <T> Variable<T>.equal(other: Variable<T>) = Condition(this, other, ConditionType.EQUAL)

/**
 * keyword used to compare two variables. e.g. "var1 notEqual var2 then { ... }"
 * equivalent to "var1 != var2"
 */
infix fun <T> Variable<T>.notEqual(other: Variable<T>) = Condition(this, other, ConditionType.NOT_EQUAL)

/**
 * keyword used to compare two variables. e.g. "var1 greaterThan var2 then { ... }"
 * equivalent to "var1 > var2"
 */
infix fun <T> Variable<T>.greaterThan(other: Variable<T>) = Condition(this, other, ConditionType.GREATER_THAN)

/**
 * keyword used to compare two variables. e.g. "var1 greaterThanOrEqual var2 then { ... }"
 * equivalent to "var1 >= var2"
 */
infix fun <T> Variable<T>.greaterThanOrEqual(other: Variable<T>) = Condition(this, other, ConditionType.GREATER_THAN_OR_EQUAL)

/**
 * keyword used to compare two variables. e.g. "var1 lessThan var2 then { ... }"
 * equivalent to "var1 < var2"
 */
infix fun <T> Variable<T>.lessThan(other: Variable<T>) = Condition(this, other, ConditionType.LESS_THAN)

/**
 * keyword used to compare two variables. e.g. "var1 lessThanOrEqual var2 then { ... }"
 * equivalent to "var1 <= var2"
 */
infix fun <T> Variable<T>.lessThanOrEqual(other: Variable<T>) = Condition(this, other, ConditionType.LESS_THAN_OR_EQUAL)

/**
 * keyword used to compare two variables. e.g. "var1 strictEqual var2 then { ... }"
 * equivalent to "var1 === var2"
 */
infix fun <T> Variable<T>.strictEqual(other: Variable<T>) = Condition(this, other, ConditionType.STRICT_EQUAL)

/**
 * keyword used to compare two variables. e.g. "var1 strictNotEqual var2 then { ... }"
 * equivalent to "var1 !== var2"
 */
infix fun <T> Variable<T>.strictNotEqual(other: Variable<T>) = Condition(this, other, ConditionType.STRICT_NOT_EQUAL)
