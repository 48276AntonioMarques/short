package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <thead> tag.
 * Description: Encapsulates a set of table rows (tr elements), indicating that they comprise the head of a table with information about the table's columns. This is usually in the form of column headers (th elements).
 */
fun Tag.Thead(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("thead", attributes, content))
}
