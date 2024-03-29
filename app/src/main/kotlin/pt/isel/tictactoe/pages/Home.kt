package pt.isel.tictactoe.pages

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlTag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Style
import pt.isel.SHORT.html.element.Text
import pt.isel.SHORT.html.id
import pt.isel.tictactoe.components.Button
import pt.isel.tictactoe.components.Leaderboard

@Page("/")
fun HtmlTag.home() = apply {
    Div(
        attributes = Attribute.id("window")
    ) {
        Div(
            attributes = Attribute.id("title")
        ) {
            Text("Tic Tac Toe")
        }
        Div(
            attributes = Attribute.id("menu")
        ) {
            Button("Play")
            Button("Login")
        }
    }
    Leaderboard()
    Style("/css/styles.css")
}
