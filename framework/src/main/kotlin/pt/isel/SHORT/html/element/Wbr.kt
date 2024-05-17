package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.VoidTag

/**
 * Represents the HTML <wbr> tag.
 * Description: Represents a word break opportunity—a position within text where the browser may optionally break a line, though its line-breaking rules would not otherwise create a break at that location.
 */
fun Tag.Wbr(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(VoidTag("wbr", attributes))
}
