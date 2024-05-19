package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onmousedown event.
 * Description: Fires when a mouse button is pressed down on an element.
 * @param value script
 */
fun Attribute.Companion.onmousedown(value: EventHandler) = add("onmousedown", value)

/**
 * Represents the HTML onmousedown event.
 * Description: Fires when a mouse button is pressed down on an element.
 * @param value script
 */
fun List<Attribute>.onmousedown(value: EventHandler) = add("onmousedown", value)
