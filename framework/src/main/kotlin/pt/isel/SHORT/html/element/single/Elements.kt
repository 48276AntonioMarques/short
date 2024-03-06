package pt.isel.SHORT.html.element.single

import pt.isel.SHORT.html.element.HtmlReceiver
import pt.isel.SHORT.html.element.prototype

fun Head(content: HtmlReceiver? = null) = prototype("head", content)

fun Body(content: HtmlReceiver? = null) = prototype("body", content)

fun Div(content: HtmlReceiver? = null) = prototype("div", content)
