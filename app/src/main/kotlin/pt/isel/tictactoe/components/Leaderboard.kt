package pt.isel.tictactoe.components

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.Text
import pt.isel.SHORT.html.attribute.id
import pt.isel.SHORT.html.element.Div

fun Tag.Leaderboard() =
    Div(
        attributes = Attribute.id("leaderboard")
    ) {
        Text("Leaderboard")
    }
