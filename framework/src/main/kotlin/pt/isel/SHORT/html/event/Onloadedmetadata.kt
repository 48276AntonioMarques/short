package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onloadedmetadata event.
 * Description: Script to be run when meta data (like dimensions and duration) are loaded.
 * @param value script
 */
fun Attribute.Companion.onloadedmetadata(value: EventHandler) = add("onloadedmetadata", value)

/**
 * Represents the HTML onloadedmetadata event.
 * Description: Script to be run when meta data (like dimensions and duration) are loaded.
 * @param value script
 */
fun List<Attribute>.onloadedmetadata(value: EventHandler) = add("onloadedmetadata", value)
