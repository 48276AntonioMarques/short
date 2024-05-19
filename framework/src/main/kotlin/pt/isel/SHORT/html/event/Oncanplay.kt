package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML oncanplay event.
 * Description: Script to be run when a file is ready to start playing (when it has buffered enough to begin).
 * @param value script
 */
fun Attribute.Companion.oncanplay(value: EventHandler) = add("oncanplay", value)

/**
 * Represents the HTML oncanplay event.
 * Description: Script to be run when a file is ready to start playing (when it has buffered enough to begin).
 * @param value script
 */
fun List<Attribute>.oncanplay(value: EventHandler) = add("oncanplay", value)
