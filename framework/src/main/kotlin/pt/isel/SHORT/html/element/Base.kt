package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <base> tag.
 * Description: Specifies the base URL to use for all relative URLs in a document. There can be only one such element in a document.
 */
fun Tag.Base(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("base", attributes, content))
}
