package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onloadeddata event.
 * Description: Script to be run when media data is loaded.
 * @param value script
 */
fun Attribute.Companion.onloadeddata(value: EventHandler) = add("onloadeddata", value)

/**
 * Represents the HTML onloadeddata event.
 * Description: Script to be run when media data is loaded.
 * @param value script
 */
fun List<Attribute>.onloadeddata(value: EventHandler) = add("onloadeddata", value)
