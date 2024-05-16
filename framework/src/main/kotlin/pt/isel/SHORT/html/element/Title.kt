package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.prototype

/**
 * Represents the HTML <title> tag.
 * Description: Defines the document's title that is shown in a browser's title bar or a page's tab. It only contains text; tags within the element are ignored.
 */
fun Tag.Title(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("title", attributes, content))
}
