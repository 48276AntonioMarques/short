package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onselect event.
 * Description: Fires after some text has been selected in an element.
 * @param value script
 */
fun Attribute.Companion.onselect(value: EventHandler) = add("onselect", value)

/**
 * Represents the HTML onselect event.
 * Description: Fires after some text has been selected in an element.
 * @param value script
 */
fun List<Attribute>.onselect(value: EventHandler) = add("onselect", value)
