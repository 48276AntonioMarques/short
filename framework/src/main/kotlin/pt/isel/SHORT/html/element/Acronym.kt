package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype

/**
 * Represents the HTML <acronym> tag.
 * Description: Allows authors to clearly indicate a sequence of characters that compose an acronym or abbreviation for a word.
 */
fun Tag.Acronym(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("acronym", attributes, scope, content))
}
