package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML oncut event.
 * Description: Fires when the user cuts the content of an element.
 * @param value script
 */
fun Attribute.Companion.oncut(value: EventHandler) = add("oncut", value)

/**
 * Represents the HTML oncut event.
 * Description: Fires when the user cuts the content of an element.
 * @param value script
 */
fun List<Attribute>.oncut(value: EventHandler) = add("oncut", value)
