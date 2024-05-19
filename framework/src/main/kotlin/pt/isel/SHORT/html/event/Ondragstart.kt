package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML ondragstart event.
 * Description: Script to be run at the start of a drag operation.
 * @param value script
 */
fun Attribute.Companion.ondragstart(value: EventHandler) = add("ondragstart", value)

/**
 * Represents the HTML ondragstart event.
 * Description: Script to be run at the start of a drag operation.
 * @param value script
 */
fun List<Attribute>.ondragstart(value: EventHandler) = add("ondragstart", value)
