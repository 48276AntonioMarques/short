package pt.isel.SHORT.html.element.single

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.element.HtmlReceiver
import pt.isel.SHORT.html.element.prototype

fun Head(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null) =
    prototype("head", attributes, content)

fun Body(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null) =
    prototype("body", attributes, content)

fun Div(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null) =
    prototype("div", attributes, content)
