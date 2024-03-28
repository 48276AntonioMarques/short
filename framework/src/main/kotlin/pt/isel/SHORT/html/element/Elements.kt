package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlTag

// Dynamically Generated
// Any changes to this file will be lost

fun HtmlTag.Head(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): HtmlTag = apply {
    appendChild(prototype("head", content))
}

fun HtmlTag.Body(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): HtmlTag = apply {
    appendChild(prototype("body", content))
}

fun HtmlTag.Div(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): HtmlTag = apply {
    appendChild(prototype("div", content))
}
