package pt.isel.SHORT.client

typealias EventHandler = EventScope.() -> Unit

class EventScope : JavaScript() {
    val event: Event = TODO()
}
