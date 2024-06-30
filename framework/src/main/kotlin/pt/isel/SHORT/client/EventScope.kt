package pt.isel.SHORT.client

import pt.isel.SHORT.comms.ContractPool
import pt.isel.SHORT.html.base.element.Tag

typealias EventHandler = EventScope.() -> Unit

class EventScope(contractPool: ContractPool, tag: Tag) : JavaScript(tag, contractPool) {
    val event: Event = Event(tag)

    init {
        literal(event.target.value, "event.target.value")
    }
}
