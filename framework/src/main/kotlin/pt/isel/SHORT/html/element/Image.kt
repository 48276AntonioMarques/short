package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <image> tag.
 * Description: An ancient and poorly supported precursor to the img element. It should not be used.
 */
fun Tag.Image(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("image", attributes, content))
}
