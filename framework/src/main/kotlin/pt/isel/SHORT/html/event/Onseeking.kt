package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onseeking event.
 * Description: Script to be run when the seeking attribute is set to true indicating that seeking is active.
 * @param value script
 */
fun Attribute.Companion.onseeking(value: EventHandler) = add("onseeking", value)

/**
 * Represents the HTML onseeking event.
 * Description: Script to be run when the seeking attribute is set to true indicating that seeking is active.
 * @param value script
 */
fun List<Attribute>.onseeking(value: EventHandler) = add("onseeking", value)
