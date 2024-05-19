package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onkeypress event.
 * Description: Fires when a user presses a key.
 * @param value script
 */
fun Attribute.Companion.onkeypress(value: EventHandler) = add("onkeypress", value)

/**
 * Represents the HTML onkeypress event.
 * Description: Fires when a user presses a key.
 * @param value script
 */
fun List<Attribute>.onkeypress(value: EventHandler) = add("onkeypress", value)
