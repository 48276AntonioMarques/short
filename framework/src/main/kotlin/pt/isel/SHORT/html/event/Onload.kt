package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onload event.
 * Description: Fires after the page is finished loading.
 * @param value script
 */
fun Attribute.Companion.onload(value: EventHandler) = add("onload", value)

/**
 * Represents the HTML onload event.
 * Description: Fires after the page is finished loading.
 * @param value script
 */
fun List<Attribute>.onload(value: EventHandler) = add("onload", value)
