package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onbeforeunload event.
 * Description: Script to be run when the document is about to be unloaded.
 * @param value script
 */
fun Attribute.Companion.onbeforeunload(value: EventHandler) = add("onbeforeunload", value)

/**
 * Represents the HTML onbeforeunload event.
 * Description: Script to be run when the document is about to be unloaded.
 * @param value script
 */
fun List<Attribute>.onbeforeunload(value: EventHandler) = add("onbeforeunload", value)
