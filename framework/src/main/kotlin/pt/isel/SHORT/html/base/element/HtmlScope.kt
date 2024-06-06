package pt.isel.SHORT.html.base.element

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.EventScope
import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.html.base.Html

class HtmlScope(val html: Html) {
    val globalScript: JavaScript = JavaScript()

    private val eventHandlers: MutableList<Pair<String, EventHandler>> = mutableListOf()
    private val variables: MutableList<Pair<String, Variable<Any>>> = mutableListOf()

    private fun <T> generateID(list: MutableList<Pair<String, T>>): String {
        val validChars = ('0'..'9') + ('A'..'Z') + ('a'..'z')
        var id = ""
        do {
            // Generate a random ID
            id = (1..10).map { validChars.random() }.joinToString("")
        } while (list.any { it.first == id })
        return id
    }

    private fun <T> addValue(list: MutableList<Pair<String, T>>, prefix: String, value: T): String {
        val id = "$prefix${generateID(list)}"
        list.add(Pair(id, value))
        return id
    }

    fun registerHandler(eventHandler: EventHandler) = addValue(eventHandlers, "eH", eventHandler)

    fun eventHandlersToHtml(): String {
        return eventHandlers.joinToString("") { (id, handler) ->
            val eventScope = EventScope(html.tag)
            eventScope.handler()
            val eventHtml = eventScope.toHtml()
            "function $id(event) {$eventHtml};"
        }
    }

    fun variablesToHtml(): String {
        return "const _SHORT_VARIABLES_ = {" + variables.joinToString(",") { (id, variable) ->
            "'$id': ${variable.defaultValue}"
        } + "};"
    }

    fun <T> newVariable(value: T): Variable<T> {
        val id = "var" + generateID(variables)
        val variable = Variable(id, value)
        variables.add(Pair(id, variable as Variable<Any>))
        return variable
    }
}
