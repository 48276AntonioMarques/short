package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onmouseup event.
 * Description: Fires when a mouse button is released over an element.
 * @param value script
 */
fun Attribute.Companion.onmouseup(value: EventHandler) = add("onmouseup", value)

/**
 * Represents the HTML onmouseup event.
 * Description: Fires when a mouse button is released over an element.
 * @param value script
 */
fun List<Attribute>.onmouseup(value: EventHandler) = add("onmouseup", value)
