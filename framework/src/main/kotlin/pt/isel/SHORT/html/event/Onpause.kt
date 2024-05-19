package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onpause event.
 * Description: Script to be run when the media is paused either by the user or programmatically.
 * @param value script
 */
fun Attribute.Companion.onpause(value: EventHandler) = add("onpause", value)

/**
 * Represents the HTML onpause event.
 * Description: Script to be run when the media is paused either by the user or programmatically.
 * @param value script
 */
fun List<Attribute>.onpause(value: EventHandler) = add("onpause", value)
