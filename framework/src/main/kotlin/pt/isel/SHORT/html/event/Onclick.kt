package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onclick event.
 * Description: Fires on a mouse click on the element.
 * @param value script
 */
fun Attribute.Companion.onclick(value: EventHandler) = add("onclick", value)

/**
 * Represents the HTML onclick event.
 * Description: Fires on a mouse click on the element.
 * @param value script
 */
fun List<Attribute>.onclick(value: EventHandler) = add("onclick", value)
