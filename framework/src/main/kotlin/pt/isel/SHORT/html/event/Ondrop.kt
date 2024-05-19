package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML ondrop event.
 * Description: Script to be run when dragged element is being dropped.
 * @param value script
 */
fun Attribute.Companion.ondrop(value: EventHandler) = add("ondrop", value)

/**
 * Represents the HTML ondrop event.
 * Description: Script to be run when dragged element is being dropped.
 * @param value script
 */
fun List<Attribute>.ondrop(value: EventHandler) = add("ondrop", value)
