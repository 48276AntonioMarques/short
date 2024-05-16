package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.VoidElement

/**
 * Represents the HTML <hr> tag.
 * Description: Represents a thematic break between paragraph-level elements: for example, a change of scene in a story, or a shift of topic within a section.
 */
fun Tag.Hr(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(VoidElement("hr", attributes))
}
