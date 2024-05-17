package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onhashchange event.
 * Description: Script to be run when there has been changes to the anchor part of the a URL.
 * @param value script
 */
fun Attribute.Companion.onhashchange(value: EventHandler) = add("onhashchange", value)

/**
 * Represents the HTML onhashchange event.
 * Description: Script to be run when there has been changes to the anchor part of the a URL.
 * @param value script
 */
fun List<Attribute>.onhashchange(value: EventHandler) = add("onhashchange", value)
