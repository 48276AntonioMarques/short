package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML ondragleave event.
 * Description: Script to be run when an element leaves a valid drop target.
 * @param value script
 */
fun Attribute.Companion.ondragleave(value: EventHandler) = add("ondragleave", value)

/**
 * Represents the HTML ondragleave event.
 * Description: Script to be run when an element leaves a valid drop target.
 * @param value script
 */
fun List<Attribute>.ondragleave(value: EventHandler) = add("ondragleave", value)
