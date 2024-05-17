package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.base.event.add

/**
 * Represents the HTML onvolumechange event.
 * Description: Script to be run each time the volume is changed which (includes setting the volume to mute).
 * @param value script
 */
fun Attribute.Companion.onvolumechange(value: EventHandler) = add("onvolumechange", value)

/**
 * Represents the HTML onvolumechange event.
 * Description: Script to be run each time the volume is changed which (includes setting the volume to mute).
 * @param value script
 */
fun List<Attribute>.onvolumechange(value: EventHandler) = add("onvolumechange", value)
