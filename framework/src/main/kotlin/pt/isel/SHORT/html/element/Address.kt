package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <address> tag.
 * Description: Indicates that the enclosed HTML provides contact information for a person or people, or for an organization.
 */
fun Tag.Address(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("address", attributes, content))
}
