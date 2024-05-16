package pt.isel.SHORT.html

/**
 * Represents a void element in HTML
 * Implementation according to the [HTML Living Standard](https://html.spec.whatwg.org/multipage/syntax.html#void-elements)
 * Termination with "/" is ignored in HTML5 but is kept for compatibility with XHTML
 * as stated on the [Void element - MDN Web Docs Glossary: Definitions of Web-related terms | MDN](https://developer.mozilla.org/en-US/docs/Glossary/Void_element)
 */
class VoidElement(
    internal val tag: String,
    internal val attributes: List<Attribute>
) : Element {
    override fun toHtml(): String {
        val attr = attributes.toHtml()
        return when {
            attr.isEmpty() -> "<$tag/>"
            else -> "<$tag $attr/>"
        }
    }

    override fun innerHtml(): String {
        // TODO: Decide if this should throw an exception or return an empty string
        throw UnsupportedOperationException("Void elements cannot have inner HTML")
    }
}
