package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onkeyup event.
 * Description: Fires when a user releases a key.
 * @param value script
 */
fun Attribute.Companion.onkeyup(value: EventHandler) = add("onkeyup", value)

/**
 * Represents the HTML onkeyup event.
 * Description: Fires when a user releases a key.
 * @param value script
 */
fun List<Attribute>.onkeyup(value: EventHandler) = add("onkeyup", value)
