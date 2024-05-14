package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <strong> tag.
 * Description: Indicates that its contents have strong importance, seriousness, or urgency. Browsers typically render the contents in bold type.
 */
fun Tag.Strong(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("strong", attributes, content))
}
