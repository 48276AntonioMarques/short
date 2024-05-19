package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onpagehide event.
 * Description: Script to be run when a user navigates away from a page.
 * @param value script
 */
fun Attribute.Companion.onpagehide(value: EventHandler) = add("onpagehide", value)

/**
 * Represents the HTML onpagehide event.
 * Description: Script to be run when a user navigates away from a page.
 * @param value script
 */
fun List<Attribute>.onpagehide(value: EventHandler) = add("onpagehide", value)
