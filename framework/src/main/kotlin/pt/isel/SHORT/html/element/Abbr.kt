package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <abbr> tag.
 * Description: Represents an abbreviation or acronym.
 */
fun Tag.Abbr(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("abbr", attributes, content))
}
