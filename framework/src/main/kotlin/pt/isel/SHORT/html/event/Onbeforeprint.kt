package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onbeforeprint event.
 * Description: Script to be run before the document is printed.
 * @param value script
 */
fun Attribute.Companion.onbeforeprint(value: EventHandler) = add("onbeforeprint", value)

/**
 * Represents the HTML onbeforeprint event.
 * Description: Script to be run before the document is printed.
 * @param value script
 */
fun List<Attribute>.onbeforeprint(value: EventHandler) = add("onbeforeprint", value)
