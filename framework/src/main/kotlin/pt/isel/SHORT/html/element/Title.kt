package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype

/**
 * Represents the HTML <title> tag.
 * Description: Defines the document's title that is shown in a browser's title bar or a page's tab. It only contains text; tags within the element are ignored.
 */
fun Tag.Title(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("title", attributes, content))
}
