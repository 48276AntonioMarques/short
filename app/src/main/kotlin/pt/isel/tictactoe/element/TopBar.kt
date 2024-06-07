package pt.isel.tictactoe.element

import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div

fun Tag.TopBar() = apply {
    Div(
        Attribute.`class`("topbar")
    ) {
        Text {
            "Player 1 (X) - Player 2 (O)"
        }
    }
}