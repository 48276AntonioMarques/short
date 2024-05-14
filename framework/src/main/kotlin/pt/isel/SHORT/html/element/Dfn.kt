package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <dfn> tag.
 * Description: Used to indicate the term being defined within the context of a definition phrase or sentence. The ancestor p element, the dt/dd pairing, or the nearest section ancestor of the dfn element, is considered to be the definition of the term.
 */
fun Tag.Dfn(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("dfn", attributes, content))
}
