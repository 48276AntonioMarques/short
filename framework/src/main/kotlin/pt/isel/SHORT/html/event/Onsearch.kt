package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onsearch event.
 * Description: Fires when the user writes something in a search field (for input=search).
 * @param value script
 */
fun Attribute.Companion.onsearch(value: EventHandler) = add("onsearch", value)

/**
 * Represents the HTML onsearch event.
 * Description: Fires when the user writes something in a search field (for input=search).
 * @param value script
 */
fun List<Attribute>.onsearch(value: EventHandler) = add("onsearch", value)
