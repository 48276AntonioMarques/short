package pt.isel.SHORT.html.base.element

import pt.isel.SHORT.Application
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.EventScope
import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.html.base.Html

class HtmlScope(val html: Html) {
    private val eventHandlers: MutableMap<String, EventHandler> = mutableMapOf()
    private val variables: MutableMap<String, Variable<*>> = mutableMapOf()

    val application: Application by lazy {
        html.application ?: throw IllegalStateException("Application is required but not provided.")
    }
    val globalScript: JavaScript by lazy { JavaScript(html.tag) }

    private fun <T> generateID(map: MutableMap<String, T>): String {
        val validChars = ('0'..'9') + ('A'..'Z') + ('a'..'z')
        var id: String
        do {
            // Generate a random ID
            id = (1..10).map { validChars.random() }.joinToString("")
        } while (map.any { entry -> entry.key == id })
        return id
    }

    private fun <T> addValue(map: MutableMap<String, T>, prefix: String, value: T): String {
        val id = "$prefix${generateID(map)}"
        map[id] = value
        return id
    }

    fun registerHandler(eventHandler: EventHandler) = addValue(eventHandlers, "eH", eventHandler)

    fun eventHandlersToHtml(): String {
        return eventHandlers.entries.joinToString("") { (id, handler) ->
            val eventScope = EventScope(html.tag)
            eventScope.handler()
            val eventHtml = eventScope.toHtml()
            "async function $id(event) {$eventHtml};"
        }
    }

    fun variablesToHtml(): String = "const _SHORT_VARIABLES_ = {" + variables.entries
        .filter { (_, variable) -> variable.isUsed }
        .joinToString(",") { (id, variable) ->
            "'$id': ${variable.defaultValue}"
        } + "};"

    fun <T> newVariable(value: T): Variable<T> {
        val id = "var" + generateID(variables)
        val variable = Variable(id, value)
        variables[id] = variable
        return variable
    }
}
