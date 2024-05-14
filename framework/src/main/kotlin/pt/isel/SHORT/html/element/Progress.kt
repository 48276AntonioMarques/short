package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <progress> tag.
 * Description: Displays an indicator showing the completion progress of a task, typically displayed as a progress bar.
 */
fun Tag.Progress(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("progress", attributes, content))
}
