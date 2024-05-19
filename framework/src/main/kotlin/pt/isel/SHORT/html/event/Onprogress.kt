package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onprogress event.
 * Description: Script to be run when the browser is in the process of getting the media data.
 * @param value script
 */
fun Attribute.Companion.onprogress(value: EventHandler) = add("onprogress", value)

/**
 * Represents the HTML onprogress event.
 * Description: Script to be run when the browser is in the process of getting the media data.
 * @param value script
 */
fun List<Attribute>.onprogress(value: EventHandler) = add("onprogress", value)
