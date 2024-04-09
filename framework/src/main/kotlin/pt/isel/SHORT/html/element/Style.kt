package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <style> tag.
 * Description: Contains style information for a document or part of a document. It contains CSS, which is applied to the contents of the document containing this element.
 */
fun Tag.Style(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("style", attributes, content))
}
