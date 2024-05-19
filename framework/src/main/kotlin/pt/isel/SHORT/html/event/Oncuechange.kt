package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML oncuechange event.
 * Description: Script to be run when the cue changes in a track element.
 * @param value script
 */
fun Attribute.Companion.oncuechange(value: EventHandler) = add("oncuechange", value)

/**
 * Represents the HTML oncuechange event.
 * Description: Script to be run when the cue changes in a track element.
 * @param value script
 */
fun List<Attribute>.oncuechange(value: EventHandler) = add("oncuechange", value)
