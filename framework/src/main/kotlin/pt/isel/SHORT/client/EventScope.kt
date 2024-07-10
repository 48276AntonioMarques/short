package pt.isel.SHORT.client

import pt.isel.SHORT.html.base.element.Tag

/**
 * Represents a scope where there is meant to be written javascript code that will be executed when an event is triggered.
 * This scope is meant to give access to the event object and its properties.
 */
typealias EventHandler = EventScope.() -> Unit

/**
 * This is the class to be used as receiver in the [EventHandler] type.
 * It provides access to the event object and its properties.
 */
class EventScope(tag: Tag) : JavaScript(tag) {
    val event = Event(tag)

    init {
        literal(event.target.value, "event.target.value")
    }
}
