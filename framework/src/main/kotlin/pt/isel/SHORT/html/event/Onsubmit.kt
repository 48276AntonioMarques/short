package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onsubmit event.
 * Description: Fires when a form is submitted.
 * @param value script
 */
fun Attribute.Companion.onsubmit(value: EventHandler) = add("onsubmit", value)

/**
 * Represents the HTML onsubmit event.
 * Description: Fires when a form is submitted.
 * @param value script
 */
fun List<Attribute>.onsubmit(value: EventHandler) = add("onsubmit", value)
