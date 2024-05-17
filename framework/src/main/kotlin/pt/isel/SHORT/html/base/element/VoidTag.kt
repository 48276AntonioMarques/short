package pt.isel.SHORT.html.base.element

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.toHtml

/**
 * Represents a void element in HTML
 * Implementation according to the [HTML Living Standard](https://html.spec.whatwg.org/multipage/syntax.html#void-elements)
 */
class VoidTag(
    internal val tag: String,
    internal val attributes: List<Attribute>
) : Element {
    override fun toHtml(): String {
        val attr = attributes.toHtml()
        return when {
            attr.isEmpty() -> "<$tag>"
            else -> "<$tag $attr>"
        }
    }

    override fun innerHtml(): String {
        // TODO: Decide if this should throw an exception or return an empty string
        throw UnsupportedOperationException("Void elements cannot have inner HTML")
    }
}
