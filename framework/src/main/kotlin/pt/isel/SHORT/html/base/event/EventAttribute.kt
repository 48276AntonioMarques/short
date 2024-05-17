package pt.isel.SHORT.html.base.event

import pt.isel.SHORT.html.base.attribute.Attribute

class EventAttribute(override val name: String, override val value: EventHandler) : Attribute {
    override fun toHtml() = "$name=\"$value\""
}

fun Attribute.Companion.add(name: String, value: EventHandler) = listOf<Attribute>(EventAttribute(name, value))
fun List<Attribute>.add(name: String, value: EventHandler) = this + EventAttribute(name, value)
