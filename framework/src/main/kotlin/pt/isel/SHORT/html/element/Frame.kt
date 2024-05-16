package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.prototype

/**
 * Represents the HTML <frame> tag.
 * Description: Defines a particular area in which another HTML document can be displayed. A frame should be used within a frameset.
 */
fun Tag.Frame(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("frame", attributes, content))
}
