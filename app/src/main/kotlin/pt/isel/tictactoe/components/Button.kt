package pt.isel.tictactoe.components

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlTag
import pt.isel.SHORT.html.element.Text
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.id

fun HtmlTag.Button(text: String) =
    Div(
        attributes = Attribute.id("button")
    ) {
        Text(text)
    }
