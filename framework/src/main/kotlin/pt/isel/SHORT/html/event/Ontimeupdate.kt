package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML ontimeupdate event.
 * Description: Script to be run when the playing position has changed (like when the user fast forwards to a different point in the media).
 * @param value script
 */
fun Attribute.Companion.ontimeupdate(value: EventHandler) = add("ontimeupdate", value)

/**
 * Represents the HTML ontimeupdate event.
 * Description: Script to be run when the playing position has changed (like when the user fast forwards to a different point in the media).
 * @param value script
 */
fun List<Attribute>.ontimeupdate(value: EventHandler) = add("ontimeupdate", value)
