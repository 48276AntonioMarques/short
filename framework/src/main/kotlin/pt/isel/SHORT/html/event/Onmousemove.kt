package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onmousemove event.
 * Description: Fires when the mouse pointer is moving while it is over an element.
 * @param value script
 */
fun Attribute.Companion.onmousemove(value: EventHandler) = add("onmousemove", value)

/**
 * Represents the HTML onmousemove event.
 * Description: Fires when the mouse pointer is moving while it is over an element.
 * @param value script
 */
fun List<Attribute>.onmousemove(value: EventHandler) = add("onmousemove", value)
