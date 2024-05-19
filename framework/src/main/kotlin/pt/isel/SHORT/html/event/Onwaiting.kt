package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onwaiting event.
 * Description: Script to be run when the media has paused but is expected to resume (like when the media pauses to buffer more data).
 * @param value script
 */
fun Attribute.Companion.onwaiting(value: EventHandler) = add("onwaiting", value)

/**
 * Represents the HTML onwaiting event.
 * Description: Script to be run when the media has paused but is expected to resume (like when the media pauses to buffer more data).
 * @param value script
 */
fun List<Attribute>.onwaiting(value: EventHandler) = add("onwaiting", value)
