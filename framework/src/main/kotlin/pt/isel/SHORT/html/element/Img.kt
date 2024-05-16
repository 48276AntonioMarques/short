package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.VoidElement

/**
 * Represents the HTML <img> tag.
 * Description: Embeds an image into the document.
 */
fun Tag.Img(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(VoidElement("img", attributes))
}
