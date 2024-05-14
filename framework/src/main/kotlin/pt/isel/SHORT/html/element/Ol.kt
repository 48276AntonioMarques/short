package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <ol> tag.
 * Description: Represents an ordered list of items — typically rendered as a numbered list.
 */
fun Tag.Ol(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("ol", attributes, content))
}
