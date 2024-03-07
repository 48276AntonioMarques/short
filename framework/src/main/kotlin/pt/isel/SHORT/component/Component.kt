package pt.isel.SHORT.component

import pt.isel.SHORT.html.HtmlElement
import pt.isel.SHORT.html.HtmlTag

class Component(children: List<HtmlElement>) : HtmlTag("component", children) {
    private val _variables = mutableListOf<Variable<Any>>()

    private fun <T> Variable(value: T): Variable<T> {
        val variable = Variable(value)
        _variables += variable as Variable<Any>
        return variable
    }
}
