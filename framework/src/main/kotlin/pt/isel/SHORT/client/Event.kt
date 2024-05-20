package pt.isel.SHORT.client

import pt.isel.SHORT.component.Variable

class Event {

    val target = Target()
    class Target {
        val value = Variable("")
    }

    fun preventDefault() {
        TODO()
    }
}
