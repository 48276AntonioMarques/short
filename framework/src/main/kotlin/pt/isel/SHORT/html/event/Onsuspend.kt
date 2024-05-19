package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onsuspend event.
 * Description: Script to be run when fetching the media data is stopped before it is completely loaded for whatever reason.
 * @param value script
 */
fun Attribute.Companion.onsuspend(value: EventHandler) = add("onsuspend", value)

/**
 * Represents the HTML onsuspend event.
 * Description: Script to be run when fetching the media data is stopped before it is completely loaded for whatever reason.
 * @param value script
 */
fun List<Attribute>.onsuspend(value: EventHandler) = add("onsuspend", value)
