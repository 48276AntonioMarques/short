package pt.isel.SHORT.html.base

import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.client.JsHandler
import pt.isel.SHORT.client.JsScope
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype

/**
 * Represents the HTML <script> tag.
 * Description: Used to embed executable code or data; this is typically used to embed or refer to JavaScript code. The script element can also be used with other languages, such as WebGL's GLSL shader programming language and JSON.
 */
fun Tag.Script(attributes: List<Attribute> = emptyList(), content: JsHandler? = null): Tag = apply {
    val html: HtmlReceiver = {
        JsScope(JavaScript(this)) {
            content?.invoke(this)
            Text {
                toHtml()
            }
        }
    }
    appendChild(prototype("script", attributes, scope, html))
}
