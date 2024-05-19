package pt.isel.SHORT.html.event

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML ondblclick event.
 * Description: Fires on a mouse double-click on the element.
 * @param value script
 */
fun Attribute.Companion.ondblclick(value: EventHandler) = add("ondblclick", value)

/**
 * Represents the HTML ondblclick event.
 * Description: Fires on a mouse double-click on the element.
 * @param value script
 */
fun List<Attribute>.ondblclick(value: EventHandler) = add("ondblclick", value)
