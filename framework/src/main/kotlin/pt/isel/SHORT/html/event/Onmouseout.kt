package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onmouseout event.
 * Description: Fires when the mouse pointer moves out of an element.
 * @param value script
 */
fun Attribute.Companion.onmouseout(value: EventHandler) = add("onmouseout", value)

/**
 * Represents the HTML onmouseout event.
 * Description: Fires when the mouse pointer moves out of an element.
 * @param value script
 */
fun List<Attribute>.onmouseout(value: EventHandler) = add("onmouseout", value)
