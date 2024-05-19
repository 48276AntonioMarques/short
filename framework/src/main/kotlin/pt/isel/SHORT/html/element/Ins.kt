package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype

/**
 * Represents the HTML <ins> tag.
 * Description: Represents a range of text that has been added to a document. You can use the del element to similarly represent a range of text that has been deleted from the document.
 */
fun Tag.Ins(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("ins", attributes, scope, content))
}
