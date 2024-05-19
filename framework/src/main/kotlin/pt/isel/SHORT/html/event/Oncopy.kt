package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML oncopy event.
 * Description: Fires when the user copies the content of an element.
 * @param value script
 */
fun Attribute.Companion.oncopy(value: EventHandler) = add("oncopy", value)

/**
 * Represents the HTML oncopy event.
 * Description: Fires when the user copies the content of an element.
 * @param value script
 */
fun List<Attribute>.oncopy(value: EventHandler) = add("oncopy", value)
