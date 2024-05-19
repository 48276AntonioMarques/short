package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onabort event.
 * Description: Script to be run on abort.
 * @param value script
 */
fun Attribute.Companion.onabort(value: EventHandler) = add("onabort", value)

/**
 * Represents the HTML onabort event.
 * Description: Script to be run on abort.
 * @param value script
 */
fun List<Attribute>.onabort(value: EventHandler) = add("onabort", value)
