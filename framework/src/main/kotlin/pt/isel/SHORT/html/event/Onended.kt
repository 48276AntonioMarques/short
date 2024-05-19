package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onended event.
 * Description: Script to be run when the media has reach the end (a useful event for messages like thanks for listening).
 * @param value script
 */
fun Attribute.Companion.onended(value: EventHandler) = add("onended", value)

/**
 * Represents the HTML onended event.
 * Description: Script to be run when the media has reach the end (a useful event for messages like thanks for listening).
 * @param value script
 */
fun List<Attribute>.onended(value: EventHandler) = add("onended", value)
