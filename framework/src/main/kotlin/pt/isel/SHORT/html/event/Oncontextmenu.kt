package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML oncontextmenu event.
 * Description: Script to be run when a context menu is triggered.
 * @param value script
 */
fun Attribute.Companion.oncontextmenu(value: EventHandler) = add("oncontextmenu", value)

/**
 * Represents the HTML oncontextmenu event.
 * Description: Script to be run when a context menu is triggered.
 * @param value script
 */
fun List<Attribute>.oncontextmenu(value: EventHandler) = add("oncontextmenu", value)
