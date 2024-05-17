package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onpaste event.
 * Description: Fires when the user pastes some content in an element.
 * @param value script
 */
fun Attribute.Companion.onpaste(value: EventHandler) = add("onpaste", value)

/**
 * Represents the HTML onpaste event.
 * Description: Fires when the user pastes some content in an element.
 * @param value script
 */
fun List<Attribute>.onpaste(value: EventHandler) = add("onpaste", value)
