package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <canvas> tag.
 * Description: Container element to use with either the canvas scripting API or the WebGL API to draw graphics and animations.
 */
fun Tag.Canvas(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("canvas", attributes, content))
}
