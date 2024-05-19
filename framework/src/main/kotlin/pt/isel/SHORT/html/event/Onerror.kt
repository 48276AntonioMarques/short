package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onerror event.
 * Description: Script to be run when an error occurs when the file is being loaded.
 * @param value script
 */
fun Attribute.Companion.onerror(value: EventHandler) = add("onerror", value)

/**
 * Represents the HTML onerror event.
 * Description: Script to be run when an error occurs when the file is being loaded.
 * @param value script
 */
fun List<Attribute>.onerror(value: EventHandler) = add("onerror", value)
