package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onpageshow event.
 * Description: Script to be run when a user navigates to a page.
 * @param value script
 */
fun Attribute.Companion.onpageshow(value: EventHandler) = add("onpageshow", value)

/**
 * Represents the HTML onpageshow event.
 * Description: Script to be run when a user navigates to a page.
 * @param value script
 */
fun List<Attribute>.onpageshow(value: EventHandler) = add("onpageshow", value)
