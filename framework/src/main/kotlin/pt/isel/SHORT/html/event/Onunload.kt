package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onunload event.
 * Description: Fires once a page has unloaded (or the browser window has been closed).
 * @param value script
 */
fun Attribute.Companion.onunload(value: EventHandler) = add("onunload", value)

/**
 * Represents the HTML onunload event.
 * Description: Fires once a page has unloaded (or the browser window has been closed).
 * @param value script
 */
fun List<Attribute>.onunload(value: EventHandler) = add("onunload", value)
