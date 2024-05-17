package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onmessage event.
 * Description: Script to be run when the message is triggered.
 * @param value script
 */
fun Attribute.Companion.onmessage(value: EventHandler) = add("onmessage", value)

/**
 * Represents the HTML onmessage event.
 * Description: Script to be run when the message is triggered.
 * @param value script
 */
fun List<Attribute>.onmessage(value: EventHandler) = add("onmessage", value)
