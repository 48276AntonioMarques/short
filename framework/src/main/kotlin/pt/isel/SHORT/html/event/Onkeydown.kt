package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onkeydown event.
 * Description: Fires when a user is pressing a key.
 * @param value script
 */
fun Attribute.Companion.onkeydown(value: EventHandler) = add("onkeydown", value)

/**
 * Represents the HTML onkeydown event.
 * Description: Fires when a user is pressing a key.
 * @param value script
 */
fun List<Attribute>.onkeydown(value: EventHandler) = add("onkeydown", value)
