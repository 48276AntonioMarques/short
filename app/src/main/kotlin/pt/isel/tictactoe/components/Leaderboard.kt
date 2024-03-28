package pt.isel.tictactoe.components

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlTag
import pt.isel.SHORT.html.Text
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.id

fun HtmlTag.Leaderboard() = apply {
    Div(
        attributes = Attribute.id("leaderboard")
    ) {
        Text("Leaderboard")
    }
}
