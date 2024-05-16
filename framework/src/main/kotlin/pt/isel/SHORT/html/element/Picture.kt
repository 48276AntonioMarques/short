package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.prototype

/**
 * Represents the HTML <picture> tag.
 * Description: Contains zero or more source elements and one img element to offer alternative versions of an image for different display/device scenarios.
 */
fun Tag.Picture(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("picture", attributes, content))
}
