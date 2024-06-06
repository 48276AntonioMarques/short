package pt.isel.SHORT.client

import pt.isel.SHORT.html.base.element.Tag

class Event(tag: Tag) {

    val target = Target(tag)
    class Target(tag: Tag) {
        val value = tag.Var("")
    }

    fun preventDefault() {
        TODO()
    }
}
