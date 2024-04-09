package pt.isel.tictactoe.components

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.attribute.id
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Text

fun Tag.Leaderboard() =
    Div(
        attributes = Attribute.id("leaderboard")
    ) {
        Text("Leaderboard")
    }