package pt.isel.SHORT.html

import pt.isel.SHORT.component.Variable
import pt.isel.SHORT.getResource
import pt.isel.SHORT.html.element.prototype

sealed interface HtmlElement

class HtmlPage(
    tag: String,
    attributes: List<Attribute>,
    children: List<HtmlElement>
) : HtmlTag(tag, attributes, children)

class HtmlText(val content: String) : HtmlElement

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

    fun toHtml(): String {
        val attr = if (attributes.isEmpty()) {
            ""
        } else {
            " " + attributes.joinToString(" ") { attribute ->
                "${attribute.name}='${attribute.value}'"
            }
        }

        val children = _children.joinToString("") { element ->
            when (element) {
                is HtmlTag -> element.toHtml()
                is HtmlText -> element.content
            }
        }
        return "<$tag$attr>$children</$tag>"
    }
}

fun Html(content: HtmlTag.() -> Unit) =
    HtmlPage("html", emptyList(), emptyList()).apply(content)

fun HtmlTag.Text(content: () -> String) = apply {
    appendChild(HtmlText(content()))
}

fun HtmlTag.Text(content: String) = apply {
    appendChild(HtmlText(content))
}

fun Text(content: () -> String) = HtmlText(content())

fun Text(content: String) = HtmlText(content)

fun HtmlTag.Script(code: () -> String) = apply {
    appendChild(
        prototype("script") {
            Text(code())
        }
    )
}

fun HtmlTag.Script(resource: String) = apply {
    val res = getResource(name = resource)
    val content = if (res != null) {
        res.readText()
    } else {
        "console.log('Resource not found: $resource')"
    }
    Script {
        content
    }
}

// For all the html tags there must exist three functions
// One that enables to append a child to the tag directly on a lambda
// Another that creates a new tag with the given content
// And a last one that creates a new tag with no content
// They should be created at pt.isel.SHORT.html.element.Elements
