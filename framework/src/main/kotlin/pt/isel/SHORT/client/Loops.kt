package pt.isel.SHORT.client

class Loop<T>(private val condition: Condition<T>, private val block: JsHandler) {
    fun toHtml(): String {
        val context = JavaScript()
        context.block()
        return "while (${condition.toHtml()}){${context.toHtml()}};"
    }
}

fun <T> JavaScript.during(condition: Condition<T>, block: JsHandler) {
    val loop = Loop(condition, block)
    append(loop.toHtml())
}
