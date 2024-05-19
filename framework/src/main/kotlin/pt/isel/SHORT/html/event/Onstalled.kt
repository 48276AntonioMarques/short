package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onstalled event.
 * Description: Script to be run when the browser is unable to fetch the media data for whatever reason.
 * @param value script
 */
fun Attribute.Companion.onstalled(value: EventHandler) = add("onstalled", value)

/**
 * Represents the HTML onstalled event.
 * Description: Script to be run when the browser is unable to fetch the media data for whatever reason.
 * @param value script
 */
fun List<Attribute>.onstalled(value: EventHandler) = add("onstalled", value)
