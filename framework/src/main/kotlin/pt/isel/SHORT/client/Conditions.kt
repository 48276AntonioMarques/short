package pt.isel.SHORT.client

class Comparison<T>(private val condition: Condition<T>, private val onSuccess: JsHandler, private val onFailure: JsHandler? = null) {

    private val script = StringBuilder()

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

    infix fun otherwise(onFailure: JsHandler) = Comparison(condition, onSuccess, onFailure)
    fun onFailure(onFailure: JsHandler) = Comparison(condition, onSuccess, onFailure)
}

fun <T> JavaScript.compare(condition: Condition<T>, onSuccess: JsHandler): Comparison<T> {
    val comparison = Comparison(condition, onSuccess)
    append(comparison.toHtml())
    return comparison
}

fun <T> JavaScript.compare(condition: Condition<T>, onSuccess: JsHandler, onFailure: JsHandler): Comparison<T> {
    val comparison = Comparison(condition, onSuccess).onFailure(onFailure)
    append(comparison.toHtml())
    return comparison
}

infix fun <T> JavaScript.compare(comparison: Comparison<T>): Comparison<T> {
    append(comparison.toHtml())
    return comparison
}


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

class Condition<T>(private val a: Variable<T>, private val b: Variable<T>, private val comparison: ConditionType) {
    fun toHtml(): String {
        return "${a.reference} ${comparison.html} ${b.reference}"
    }

    infix fun then(onSuccess: JsHandler): Comparison<T> {
        return Comparison(this, onSuccess)
    }
}

infix fun <T> Variable<T>.equal(other: Variable<T>) = Condition(this, other, ConditionType.EQUAL)
infix fun <T> Variable<T>.notEqual(other: Variable<T>) = Condition(this, other, ConditionType.NOT_EQUAL)
infix fun <T> Variable<T>.greaterThan(other: Variable<T>) = Condition(this, other, ConditionType.GREATER_THAN)
infix fun <T> Variable<T>.greaterThanOrEqual(other: Variable<T>) = Condition(this, other, ConditionType.GREATER_THAN_OR_EQUAL)
infix fun <T> Variable<T>.lessThan(other: Variable<T>) = Condition(this, other, ConditionType.LESS_THAN)
infix fun <T> Variable<T>.lessThanOrEqual(other: Variable<T>) = Condition(this, other, ConditionType.LESS_THAN_OR_EQUAL)
infix fun <T> Variable<T>.strictEqual(other: Variable<T>) = Condition(this, other, ConditionType.STRICT_EQUAL)
infix fun <T> Variable<T>.strictNotEqual(other: Variable<T>) = Condition(this, other, ConditionType.STRICT_NOT_EQUAL)
