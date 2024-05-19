package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML ondragend event.
 * Description: Script to be run at the end of a drag operation.
 * @param value script
 */
fun Attribute.Companion.ondragend(value: EventHandler) = add("ondragend", value)

/**
 * Represents the HTML ondragend event.
 * Description: Script to be run at the end of a drag operation.
 * @param value script
 */
fun List<Attribute>.ondragend(value: EventHandler) = add("ondragend", value)
