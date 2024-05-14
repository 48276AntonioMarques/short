package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <rp> tag.
 * Description: Used to provide fall-back parentheses for browsers that do not support the display of ruby annotations using the ruby element. One rp element should enclose each of the opening and closing parentheses that wrap the rt element that contains the annotation's text.
 */
fun Tag.Rp(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("rp", attributes, content))
}
