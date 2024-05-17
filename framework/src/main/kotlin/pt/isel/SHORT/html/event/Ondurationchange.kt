package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML ondurationchange event.
 * Description: Script to be run when the length of the media changes.
 * @param value script
 */
fun Attribute.Companion.ondurationchange(value: EventHandler) = add("ondurationchange", value)

/**
 * Represents the HTML ondurationchange event.
 * Description: Script to be run when the length of the media changes.
 * @param value script
 */
fun List<Attribute>.ondurationchange(value: EventHandler) = add("ondurationchange", value)
