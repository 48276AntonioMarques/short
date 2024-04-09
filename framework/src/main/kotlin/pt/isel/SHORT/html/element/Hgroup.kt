package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <hgroup> tag.
 * Description: Represents a heading grouped with any secondary content, such as subheadings, an alternative title, or a tagline.
 */
fun Tag.Hgroup(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("hgroup", attributes, content))
}
