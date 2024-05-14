package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <dt> tag.
 * Description: Specifies a term in a description or definition list, and as such must be used inside a dl element. It is usually followed by a dd element; however, multiple dt elements in a row indicate several terms that are all defined by the immediate next dd element.
 */
fun Tag.Dt(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("dt", attributes, content))
}
