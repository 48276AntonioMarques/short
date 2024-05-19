package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML oninput event.
 * Description: Script to be run when an element gets user input.
 * @param value script
 */
fun Attribute.Companion.oninput(value: EventHandler) = add("oninput", value)

/**
 * Represents the HTML oninput event.
 * Description: Script to be run when an element gets user input.
 * @param value script
 */
fun List<Attribute>.oninput(value: EventHandler) = add("oninput", value)
