package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <summary> tag.
 * Description: Specifies a summary, caption, or legend for a details element's disclosure box. Clicking the summary element toggles the state of the parent details element open and closed.
 */
fun Tag.Summary(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("summary", attributes, content))
}
