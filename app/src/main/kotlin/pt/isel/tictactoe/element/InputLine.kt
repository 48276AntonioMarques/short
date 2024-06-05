package pt.isel.tictactoe.element

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Input
import pt.isel.SHORT.html.event.onchange

fun Tag.InputLine(text: String, color: String, onChange: EventHandler) = apply {
    Div(Attribute.`class`("input-container $color")) {
        Text { text }
        Input(Attribute.onchange(onChange))
    }
}

fun Tag.InputLine(text: String, color: String) = InputLine(text, color) {}

fun Tag.InputLine(text: String, onChange: EventHandler) = InputLine(text, "", onChange)

fun Tag.InputLine(text: String) = InputLine(text, "")
