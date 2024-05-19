package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype

/**
 * Represents the HTML <marquee> tag.
 * Description: Used to insert a scrolling area of text. You can control what happens when the text reaches the edges of its content area using its attributes.
 */
fun Tag.Marquee(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("marquee", attributes, scope, content))
}
