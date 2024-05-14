package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <form> tag.
 * Description: Represents a document section containing interactive controls for submitting information.
 */
fun Tag.Form(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("form", attributes, content))
}
