package pt.isel.tictactoe.components

import pt.isel.SHORT.component.Component
import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Text

@Component
fun Tag.Button(text: String, color: String, onClick: () -> Unit) =
    Div(
        attributes = Attribute.`class`(if (color.isNotBlank()) "button $color" else "button")
    ) {
        Text(text)
    }

fun Tag.Button(text: String) = Button(text) {}

fun Tag.Button(text : String, color: String) = Button(text, color) {}

fun Tag.Button(text: String, onClick: () -> Unit) = Button(text, "", onClick)
