package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onoffline event.
 * Description: Script to be run when the browser starts to work offline.
 * @param value script
 */
fun Attribute.Companion.onoffline(value: EventHandler) = add("onoffline", value)

/**
 * Represents the HTML onoffline event.
 * Description: Script to be run when the browser starts to work offline.
 * @param value script
 */
fun List<Attribute>.onoffline(value: EventHandler) = add("onoffline", value)
