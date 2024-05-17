package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML ondrag event.
 * Description: Script to be run when an element is dragged.
 * @param value script
 */
fun Attribute.Companion.ondrag(value: EventHandler) = add("ondrag", value)

/**
 * Represents the HTML ondrag event.
 * Description: Script to be run when an element is dragged.
 * @param value script
 */
fun List<Attribute>.ondrag(value: EventHandler) = add("ondrag", value)
