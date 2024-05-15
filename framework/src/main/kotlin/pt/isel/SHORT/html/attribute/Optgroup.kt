package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <optgroup> tag.
 * Description: Creates a grouping of options within a select element.
 */
fun Tag.Optgroup(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("optgroup", attributes, content))
}