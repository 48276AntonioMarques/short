package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <dialog> tag.
 * Description: Represents a dialog box or other interactive component, such as a dismissible alert, inspector, or subwindow.
 */
fun Tag.Dialog(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("dialog", attributes, content))
}
