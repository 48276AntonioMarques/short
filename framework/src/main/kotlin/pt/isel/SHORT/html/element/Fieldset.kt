package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <fieldset> tag.
 * Description: Used to group several controls as well as labels (label) within a web form.
 */
fun Tag.Fieldset(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("fieldset", attributes, content))
}
