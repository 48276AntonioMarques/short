package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onpopstate event.
 * Description: Script to be run when the window's history changes.
 * @param value script
 */
fun Attribute.Companion.onpopstate(value: EventHandler) = add("onpopstate", value)

/**
 * Represents the HTML onpopstate event.
 * Description: Script to be run when the window's history changes.
 * @param value script
 */
fun List<Attribute>.onpopstate(value: EventHandler) = add("onpopstate", value)
