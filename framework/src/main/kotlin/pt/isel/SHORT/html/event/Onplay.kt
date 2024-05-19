package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onplay event.
 * Description: Script to be run when the media is ready to start playing.
 * @param value script
 */
fun Attribute.Companion.onplay(value: EventHandler) = add("onplay", value)

/**
 * Represents the HTML onplay event.
 * Description: Script to be run when the media is ready to start playing.
 * @param value script
 */
fun List<Attribute>.onplay(value: EventHandler) = add("onplay", value)
