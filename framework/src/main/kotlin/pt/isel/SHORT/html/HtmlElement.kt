package pt.isel.SHORT.html

import pt.isel.SHORT.component.Variable

sealed interface HtmlElement {
    fun toHtml(): String
}

class HtmlPage(
    tag: String,
    attributes: List<Attribute>,
    children: List<HtmlElement>
) : HtmlTag(tag, attributes, children)

fun Html(content: HtmlTag.() -> Unit) =
    HtmlPage("html", emptyList(), emptyList()).apply(content)

class HtmlText(val content: () -> String) : HtmlElement {
    override fun toHtml() = content()
}

open class HtmlTag(
    private val tag: String,
    private val attributes: List<Attribute>,
    children: List<HtmlElement>
) : HtmlElement {
    private val _children = children.toMutableList()

    private val _variables = mutableListOf<Variable<Any>>()

    // This function exists in JS
    // Ensure that the HTML generator does not try to recreate the same function
    fun appendChild(child: HtmlElement): HtmlElement {
        _children += child
        return this
    }

    fun appendVariable(variable: Variable<Any>) {
        _variables += variable
    }

    override fun toHtml(): String {
        val attr = if (attributes.isEmpty()) {
            ""
        } else {
            " " + attributes.joinToString(" ") { attribute ->
                "${attribute.name}='${attribute.value}'"
            }
        }
        return "<$tag$attr>${innerHtml()}</$tag>"
    }

    // This function exists in JS
    // Ensure that the HTML generator does not try to recreate the same function
    fun innerHtml() = _children.joinToString("") { element -> element.toHtml() }
}
