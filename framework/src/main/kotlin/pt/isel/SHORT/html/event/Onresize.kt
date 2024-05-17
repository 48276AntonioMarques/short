package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onresize event.
 * Description: Fires when the browser window is resized.
 * @param value script
 */
fun Attribute.Companion.onresize(value: EventHandler) = add("onresize", value)

/**
 * Represents the HTML onresize event.
 * Description: Fires when the browser window is resized.
 * @param value script
 */
fun List<Attribute>.onresize(value: EventHandler) = add("onresize", value)
