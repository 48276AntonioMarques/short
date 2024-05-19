package pt.isel.SHORT.html.event

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML ontoggle event.
 * Description: Fires when the user opens or closes the details element.
 * @param value script
 */
fun Attribute.Companion.ontoggle(value: EventHandler) = add("ontoggle", value)

/**
 * Represents the HTML ontoggle event.
 * Description: Fires when the user opens or closes the details element.
 * @param value script
 */
fun List<Attribute>.ontoggle(value: EventHandler) = add("ontoggle", value)
