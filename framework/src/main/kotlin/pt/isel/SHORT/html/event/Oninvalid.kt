package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML oninvalid event.
 * Description: Script to be run when an element is invalid.
 * @param value script
 */
fun Attribute.Companion.oninvalid(value: EventHandler) = add("oninvalid", value)

/**
 * Represents the HTML oninvalid event.
 * Description: Script to be run when an element is invalid.
 * @param value script
 */
fun List<Attribute>.oninvalid(value: EventHandler) = add("oninvalid", value)
