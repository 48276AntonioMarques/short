package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <rb> tag.
 * Description: Used to delimit the base text component of a ruby annotation, i.e. the text that is being annotated. One rb element should wrap each separate atomic segment of the base text.
 */
fun Tag.Rb(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("rb", attributes, content))
}
