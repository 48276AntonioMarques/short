package pt.isel.SHORT.client

import pt.isel.SHORT.html.base.element.Tag

typealias EventHandler = EventScope.() -> Unit

class EventScope(tag: Tag) : JavaScript() {
    val event: Event = Event(tag)

    init {
        literal(event.target.value, "event.target.value")
    }
}
