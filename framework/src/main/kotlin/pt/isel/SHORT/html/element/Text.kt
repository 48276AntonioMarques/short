package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.Text as TextClass

fun Tag.Text(content: () -> String) = apply {
    appendChild(TextClass(content))
}

fun Tag.Text(content: String) = Text { content }
