package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.prototype

/**
 * Represents the HTML <portal> tag.
 * Description: Enables the embedding of another HTML page into the current one to enable smoother navigation into new pages.
 */
fun Tag.Portal(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("portal", attributes, content))
}
