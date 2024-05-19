package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onfocus event.
 * Description: Fires the moment when the element gets focus.
 * @param value script
 */
fun Attribute.Companion.onfocus(value: EventHandler) = add("onfocus", value)

/**
 * Represents the HTML onfocus event.
 * Description: Fires the moment when the element gets focus.
 * @param value script
 */
fun List<Attribute>.onfocus(value: EventHandler) = add("onfocus", value)
