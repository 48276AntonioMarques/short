package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.prototype

/**
 * Represents the HTML <marquee> tag.
 * Description: Used to insert a scrolling area of text. You can control what happens when the text reaches the edges of its content area using its attributes.
 */
fun Tag.Marquee(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("marquee", attributes, content))
}
