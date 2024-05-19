package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onemptied event.
 * Description: Script to be run when something bad happens and the file is suddenly unavailable (like unexpectedly disconnects).
 * @param value script
 */
fun Attribute.Companion.onemptied(value: EventHandler) = add("onemptied", value)

/**
 * Represents the HTML onemptied event.
 * Description: Script to be run when something bad happens and the file is suddenly unavailable (like unexpectedly disconnects).
 * @param value script
 */
fun List<Attribute>.onemptied(value: EventHandler) = add("onemptied", value)
