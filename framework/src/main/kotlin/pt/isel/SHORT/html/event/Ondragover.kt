package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML ondragover event.
 * Description: Script to be run when an element is being dragged over a valid drop target.
 * @param value script
 */
fun Attribute.Companion.ondragover(value: EventHandler) = add("ondragover", value)

/**
 * Represents the HTML ondragover event.
 * Description: Script to be run when an element is being dragged over a valid drop target.
 * @param value script
 */
fun List<Attribute>.ondragover(value: EventHandler) = add("ondragover", value)
