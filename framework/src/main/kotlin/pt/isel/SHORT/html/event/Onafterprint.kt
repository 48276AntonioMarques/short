package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onafterprint event.
 * Description: Script to be run after the document is printed.
 * @param value script
 */
fun Attribute.Companion.onafterprint(value: EventHandler) = add("onafterprint", value)

/**
 * Represents the HTML onafterprint event.
 * Description: Script to be run after the document is printed.
 * @param value script
 */
fun List<Attribute>.onafterprint(value: EventHandler) = add("onafterprint", value)
