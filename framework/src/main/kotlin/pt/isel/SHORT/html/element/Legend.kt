package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <legend> tag.
 * Description: Represents a caption for the content of its parent fieldset.
 */
fun Tag.Legend(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("legend", attributes, content))
}
