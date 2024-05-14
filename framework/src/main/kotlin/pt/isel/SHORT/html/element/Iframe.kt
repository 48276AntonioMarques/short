package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <iframe> tag.
 * Description: Represents a nested browsing context, embedding another HTML page into the current one.
 */
fun Tag.Iframe(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("iframe", attributes, content))
}
