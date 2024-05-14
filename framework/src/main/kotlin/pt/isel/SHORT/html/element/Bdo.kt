package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <bdo> tag.
 * Description: Overrides the current directionality of text, so that the text within is rendered in a different direction.
 */
fun Tag.Bdo(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("bdo", attributes, content))
}
