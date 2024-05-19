package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML onratechange event.
 * Description: Script to be run each time the playback rate changes (like when a user switches to a slow motion or fast forward mode).
 * @param value script
 */
fun Attribute.Companion.onratechange(value: EventHandler) = add("onratechange", value)

/**
 * Represents the HTML onratechange event.
 * Description: Script to be run each time the playback rate changes (like when a user switches to a slow motion or fast forward mode).
 * @param value script
 */
fun List<Attribute>.onratechange(value: EventHandler) = add("onratechange", value)
