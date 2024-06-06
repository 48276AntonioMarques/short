package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.VoidTag

/**
 * Represents the HTML <col> tag.
 * Description: Defines one or more columns in a column group represented by its implicit or explicit parent colgroup element. The col element is only valid as a child of a colgroup element that has no span attribute defined.
 */
fun Tag.Col(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(VoidTag("col", attributes, scope))
}
