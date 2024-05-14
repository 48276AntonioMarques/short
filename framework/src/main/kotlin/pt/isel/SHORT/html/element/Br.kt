package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <br> tag.
 * Description: Produces a line break in text (carriage-return). It is useful for writing a poem or an address, where the division of lines is significant.
 */
fun Tag.Br(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("br", attributes, content))
}
