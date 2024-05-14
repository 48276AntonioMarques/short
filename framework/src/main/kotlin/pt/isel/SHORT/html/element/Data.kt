package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <data> tag.
 * Description: Links a given piece of content with a machine-readable translation. If the content is time- or date-related, thetime element must be used.
 */
fun Tag.Data(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("data", attributes, content))
}
