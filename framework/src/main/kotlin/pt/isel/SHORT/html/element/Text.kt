package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.HtmlTag
import pt.isel.SHORT.html.HtmlText

fun HtmlTag.Text(content: () -> String) = apply {
    appendChild(HtmlText(content))
}

fun HtmlTag.Text(content: String) = apply {
    appendChild(HtmlText { content })
}
