package pt.isel.SHORT.component

data class Variable<T>(val value: T) {

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
