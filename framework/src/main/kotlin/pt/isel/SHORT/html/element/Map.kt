package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <map> tag.
 * Description: Used with area elements to define an image map (a clickable link area).
 */
fun Tag.Map(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("map", attributes, content))
}
