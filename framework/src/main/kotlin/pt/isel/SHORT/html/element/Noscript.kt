package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.prototype

/**
 * Represents the HTML <noscript> tag.
 * Description: Defines a section of HTML to be inserted if a script type on the page is unsupported or if scripting is currently turned off in the browser.
 */
fun Tag.Noscript(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("noscript", attributes, content))
}
