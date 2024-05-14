package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <acronym> tag.
 * Description: Allows authors to clearly indicate a sequence of characters that compose an acronym or abbreviation for a word.
 */
fun Tag.Acronym(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("acronym", attributes, content))
}
