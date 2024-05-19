package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML ondragenter event.
 * Description: Script to be run when an element has been dragged to a valid drop target.
 * @param value script
 */
fun Attribute.Companion.ondragenter(value: EventHandler) = add("ondragenter", value)

/**
 * Represents the HTML ondragenter event.
 * Description: Script to be run when an element has been dragged to a valid drop target.
 * @param value script
 */
fun List<Attribute>.ondragenter(value: EventHandler) = add("ondragenter", value)
