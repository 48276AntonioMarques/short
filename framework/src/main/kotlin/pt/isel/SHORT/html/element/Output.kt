package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <output> tag.
 * Description: Container element into which a site or app can inject the results of a calculation or the outcome of a user action.
 */
fun Tag.Output(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("output", attributes, content))
}
