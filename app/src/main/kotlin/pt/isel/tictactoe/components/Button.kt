package pt.isel.tictactoe.components

import pt.isel.SHORT.component.Component
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.event.EventHandler
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.event.onclick

@Component
fun Tag.Button(text: String, color: String, onClick: EventHandler) =
    Div(
        attributes = Attribute.`class`(if (color.isNotBlank()) "button $color" else "button")
            .onclick(onClick)
    ) {
        Text(text)
    }

fun Tag.Button(text: String) = Button(text) {}

fun Tag.Button(text: String, color: String) = Button(text, color) {}

fun Tag.Button(text: String, onClick: EventHandler) = Button(text, "", onClick)
