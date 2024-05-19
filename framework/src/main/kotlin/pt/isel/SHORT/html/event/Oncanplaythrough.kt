package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML oncanplaythrough event.
 * Description: Script to be run when a file can be played all the way to the end without pausing for buffering.
 * @param value script
 */
fun Attribute.Companion.oncanplaythrough(value: EventHandler) = add("oncanplaythrough", value)

/**
 * Represents the HTML oncanplaythrough event.
 * Description: Script to be run when a file can be played all the way to the end without pausing for buffering.
 * @param value script
 */
fun List<Attribute>.oncanplaythrough(value: EventHandler) = add("oncanplaythrough", value)
