package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onstorage event.
 * Description: Script to be run when a Web Storage area is updated.
 * @param value script
 */
fun Attribute.Companion.onstorage(value: EventHandler) = add("onstorage", value)

/**
 * Represents the HTML onstorage event.
 * Description: Script to be run when a Web Storage area is updated.
 * @param value script
 */
fun List<Attribute>.onstorage(value: EventHandler) = add("onstorage", value)
