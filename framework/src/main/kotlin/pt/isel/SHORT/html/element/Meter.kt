package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <meter> tag.
 * Description: Represents either a scalar value within a known range or a fractional value.
 */
fun Tag.Meter(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("meter", attributes, content))
}
