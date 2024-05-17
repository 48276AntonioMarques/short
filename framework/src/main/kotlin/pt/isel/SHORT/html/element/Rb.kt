package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype

/**
 * Represents the HTML <rb> tag.
 * Description: Used to delimit the base text component of a ruby annotation, i.e. the text that is being annotated. One rb element should wrap each separate atomic segment of the base text.
 */
fun Tag.Rb(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("rb", attributes, content))
}
