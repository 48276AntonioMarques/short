package pt.isel.SHORT.html

/**
 * Represents a void element in HTML
 * Implementation according to the [HTML Living Standard](https://html.spec.whatwg.org/multipage/syntax.html#void-elements)
 */
class VoidElement(
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
