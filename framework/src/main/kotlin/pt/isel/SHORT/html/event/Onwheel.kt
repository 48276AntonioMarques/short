package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onwheel event.
 * Description: Fires when the mouse wheel rolls up or down over an element.
 * @param value script
 */
fun Attribute.Companion.onwheel(value: EventHandler) = add("onwheel", value)

/**
 * Represents the HTML onwheel event.
 * Description: Fires when the mouse wheel rolls up or down over an element.
 * @param value script
 */
fun List<Attribute>.onwheel(value: EventHandler) = add("onwheel", value)
