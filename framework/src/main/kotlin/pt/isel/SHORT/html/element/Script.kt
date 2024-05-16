package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.prototype

/**
 * Represents the HTML <script> tag.
 * Description: Used to embed executable code or data; this is typically used to embed or refer to JavaScript code. The script element can also be used with other languages, such as WebGL's GLSL shader programming language and JSON.
 */
fun Tag.Script(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("script", attributes, content))
}
