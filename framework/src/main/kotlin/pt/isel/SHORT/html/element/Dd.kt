package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <dd> tag.
 * Description: Provides the description, definition, or value for the preceding term (dt) in a description list (dl).
 */
fun Tag.Dd(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("dd", attributes, content))
}
