package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype

/**
 * Represents the HTML <footer> tag.
 * Description: Represents a footer for its nearest ancestor sectioning content or sectioning root element. A footer typically contains information about the author of the section, copyright data, or links to related documents.
 */
fun Tag.Footer(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("footer", attributes, scope, content))
}
