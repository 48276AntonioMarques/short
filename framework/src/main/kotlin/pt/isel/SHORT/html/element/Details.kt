package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <details> tag.
 * Description: Creates a disclosure widget in which information is visible only when the widget is toggled into an \"open\" state. A summary or label must be provided using the summary element.
 */
fun Tag.Details(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("details", attributes, content))
}
