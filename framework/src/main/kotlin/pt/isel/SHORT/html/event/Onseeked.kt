package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onseeked event.
 * Description: Script to be run when the seeking attribute is set to false indicating that seeking has ended.
 * @param value script
 */
fun Attribute.Companion.onseeked(value: EventHandler) = add("onseeked", value)

/**
 * Represents the HTML onseeked event.
 * Description: Script to be run when the seeking attribute is set to false indicating that seeking has ended.
 * @param value script
 */
fun List<Attribute>.onseeked(value: EventHandler) = add("onseeked", value)
