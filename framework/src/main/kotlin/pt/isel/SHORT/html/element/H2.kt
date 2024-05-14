package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <h2> tag.
 * Description: Represent six levels of section headings. h1 is the highest section level and h6 is the lowest.
 */
fun Tag.H2(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("h2", attributes, content))
}
