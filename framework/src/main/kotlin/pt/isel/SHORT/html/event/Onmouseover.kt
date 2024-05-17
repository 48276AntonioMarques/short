package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onmouseover event.
 * Description: Fires when the mouse pointer moves over an element.
 * @param value script
 */
fun Attribute.Companion.onmouseover(value: EventHandler) = add("onmouseover", value)

/**
 * Represents the HTML onmouseover event.
 * Description: Fires when the mouse pointer moves over an element.
 * @param value script
 */
fun List<Attribute>.onmouseover(value: EventHandler) = add("onmouseover", value)
