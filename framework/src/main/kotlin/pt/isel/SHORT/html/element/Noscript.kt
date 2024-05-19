package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype

/**
 * Represents the HTML <noscript> tag.
 * Description: Defines a section of HTML to be inserted if a script type on the page is unsupported or if scripting is currently turned off in the browser.
 */
fun Tag.Noscript(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("noscript", attributes, scope, content))
}
