package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onplaying event.
 * Description: Script to be run when the media actually has started playing.
 * @param value script
 */
fun Attribute.Companion.onplaying(value: EventHandler) = add("onplaying", value)

/**
 * Represents the HTML onplaying event.
 * Description: Script to be run when the media actually has started playing.
 * @param value script
 */
fun List<Attribute>.onplaying(value: EventHandler) = add("onplaying", value)
