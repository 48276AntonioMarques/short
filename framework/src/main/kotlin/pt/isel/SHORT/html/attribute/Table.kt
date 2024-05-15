package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

/**
 * Represents the HTML <table> tag.
 * Description: Represents tabular data—that is, information presented in a two-dimensional table comprised of rows and columns of cells containing data.
 */
fun Tag.Table(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("table", attributes, content))
}
