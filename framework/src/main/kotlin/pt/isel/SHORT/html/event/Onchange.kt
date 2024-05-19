package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onchange event.
 * Description: Fires the moment when the value of the element is changed.
 * @param value script
 */
fun Attribute.Companion.onchange(value: EventHandler) = add("onchange", value)

/**
 * Represents the HTML onchange event.
 * Description: Fires the moment when the value of the element is changed.
 * @param value script
 */
fun List<Attribute>.onchange(value: EventHandler) = add("onchange", value)
