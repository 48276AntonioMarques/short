package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onblur event.
 * Description: Fires the moment that the element loses focus.
 * @param value script
 */
fun Attribute.Companion.onblur(value: EventHandler) = add("onblur", value)

/**
 * Represents the HTML onblur event.
 * Description: Fires the moment that the element loses focus.
 * @param value script
 */
fun List<Attribute>.onblur(value: EventHandler) = add("onblur", value)
