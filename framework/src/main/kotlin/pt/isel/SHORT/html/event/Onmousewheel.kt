package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onmousewheel event.
 * Description: Deprecated. Use the onwheel attribute instead.
 * @param value script
 */
@Deprecated("This event is deprecated.")
fun Attribute.Companion.onmousewheel(value: EventHandler) = add("onmousewheel", value)

/**
 * Represents the HTML onmousewheel event.
 * Description: Deprecated. Use the onwheel attribute instead.
 * @param value script
 */
@Deprecated("This event is deprecated.")
fun List<Attribute>.onmousewheel(value: EventHandler) = add("onmousewheel", value)
