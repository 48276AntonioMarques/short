package pt.isel.SHORT.html.base.element

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.EventScope
import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.html.base.Html

class HtmlScope(val html: Html) {
    val globalScript: JavaScript = JavaScript()

    private val eventHandlers: MutableList<Pair<String, EventHandler>> = mutableListOf()

    private fun generateEventID(): String {
        val validChars = ('0'..'9') + ('A'..'Z') + ('a'..'z')
        var id = ""
        do {
            // Generate a random ID
            id = "eH" + (1..10).map { validChars.random() }.joinToString("")
        } while (eventHandlers.any { it.first == id })
        println("Generated event ID: $id")
        return id
    }

    fun registerHandler(eventHandler: EventHandler): String {
        val id = generateEventID()
        eventHandlers.add(Pair(id, eventHandler))
        return id
    }

    fun eventHandlersToHtml(): String {
        return eventHandlers.joinToString("") { (id, handler) ->
            val eventScope = EventScope()
            eventScope.handler()
            val eventHtml = eventScope.toHtml()
            "function $id(event) {$eventHtml};"
        }
    }
}
