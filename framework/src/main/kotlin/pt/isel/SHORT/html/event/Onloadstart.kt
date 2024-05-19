package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onloadstart event.
 * Description: Script to be run just as the file begins to load before anything is actually loaded.
 * @param value script
 */
fun Attribute.Companion.onloadstart(value: EventHandler) = add("onloadstart", value)

/**
 * Represents the HTML onloadstart event.
 * Description: Script to be run just as the file begins to load before anything is actually loaded.
 * @param value script
 */
fun List<Attribute>.onloadstart(value: EventHandler) = add("onloadstart", value)
