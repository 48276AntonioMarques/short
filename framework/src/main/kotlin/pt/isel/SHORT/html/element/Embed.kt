package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <embed> tag.
 * Description: Embeds external content at the specified point in the document. This content is provided by an external application or other source of interactive content such as a browser plug-in.
 */
fun Tag.Embed(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("embed", attributes, content))
}