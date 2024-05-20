package pt.isel.SHORT.component

import pt.isel.SHORT.html.base.element.Tag

fun <T : Any> Tag.Var(value: T) =
    Variable(value).also { variable ->
        val id = scope.appendVariable(variable as Variable<Any>)
        variable.setID(id)
    }

class Variable<T>(value: T) {
    var reference = ""
        private set
    private var _value = value
    val value: String // This must be an object
        get() = "code to get value"

    fun setID(id: String) {
        reference = id
    }

    /**
     * Function to set the value of the variable
     * @param value the value to be set
     * This function will set the value of the variable based on the value of another variable
     */
    fun setValue(value: Variable<T>) {
    }

    /**
     * Function to set the value of the variable
     * @param value the value to be set
     * This function will statically set the value of the variable
     */
    fun setValue(value: T) {
    }

    class Condition(val a: Variable<*>, val b: Variable<*>) {
        infix fun then(block: () -> Unit): Condition {
            return this
        }

        infix fun Else(block: () -> Unit): EndedCondition {
            return EndedCondition(a, b)
        }
    }

    class EndedCondition(val a: Variable<*>, val b: Variable<*>)
    infix fun compareWith(value: Variable<T>) = Condition(this, value)
    infix fun compareWith(value: T) = Condition(this, Variable(value))
}

class SwitchCase<T>(private val value: Variable<T>, private val case: Variable<T>) {
    infix fun Then(block: () -> Unit) {
    }
}

class SwitchCondition<T>(private val value: Variable<T>) {
    fun case(value: Variable<T>): SwitchCase<T> = SwitchCase(this.value, value)
}

fun <T> switch(value: Variable<T>, block: SwitchCondition<T>.() -> Unit) {
    SwitchCondition(value).block()
}
