package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML ononline event.
 * Description: Script to be run when the browser starts to work online.
 * @param value script
 */
fun Attribute.Companion.ononline(value: EventHandler) = add("ononline", value)

/**
 * Represents the HTML ononline event.
 * Description: Script to be run when the browser starts to work online.
 * @param value script
 */
fun List<Attribute>.ononline(value: EventHandler) = add("ononline", value)
