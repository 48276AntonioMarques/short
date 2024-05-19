package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onreset event.
 * Description: Fires when the Reset button in a form is clicked.
 * @param value script
 */
fun Attribute.Companion.onreset(value: EventHandler) = add("onreset", value)

/**
 * Represents the HTML onreset event.
 * Description: Fires when the Reset button in a form is clicked.
 * @param value script
 */
fun List<Attribute>.onreset(value: EventHandler) = add("onreset", value)
