package pt.isel.SHORT.html.base.attribute

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.EventScope
import pt.isel.SHORT.html.base.element.HtmlScope

class EventAttribute(override val name: String, override val value: EventHandler) : Attribute {
    private var eventID = ""

    fun register(scope: HtmlScope) {
        eventID = scope.registerHandler(value)
    }

    override fun toHtml(): String {
        // This needs the HtmlScope of the tag to be able to generate the event attribute
        if (eventID.isNotBlank()) return "$name=\"$eventID(event)\""
        val event = EventScope()
        event.value()
        println("Event not registered. id($eventID) value (${event.toHtml()})")
        throw EventException("Event not registered.")
    }
}

fun Attribute.Companion.add(name: String, value: EventHandler) = listOf<Attribute>(EventAttribute(name, value))
fun List<Attribute>.add(name: String, value: EventHandler) = this + EventAttribute(name, value)

class EventException(message: String) : RuntimeException(message)
