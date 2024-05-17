package pt.isel.SHORT.html.base

import pt.isel.SHORT.html.base.element.Element
import pt.isel.SHORT.html.base.element.Tag

class TextClass(val content: String) : Element {
    override fun toHtml(): String = content
    override fun innerHtml(): String = content
}

/**
 * Generates text inside the current element.
 * @param content is a lambda with context.
 * The [KFunction] provided will be executed when the corresponding page is created.
 * The [String] generated will never change.
 */
fun Tag.Text(content: () -> String) = apply {
    appendChild(TextClass(content()))
}

/**
 * Generates text inside the current element.
 * @param content The text content.
 * The [String] provided will never change.
 */
fun Tag.Text(content: String) = Text { content }
