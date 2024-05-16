package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.VoidElement

/**
 * Represents the HTML <meta> tag.
 * Description: Represents metadata that cannot be represented by other HTML meta-related elements, like base, link, script, style and title.
 */
fun Tag.Meta(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(VoidElement("meta", attributes))
}
