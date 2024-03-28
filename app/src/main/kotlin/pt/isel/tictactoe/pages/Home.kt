package pt.isel.tictactoe.pages

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Text
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.single.Div
import pt.isel.SHORT.html.id
import pt.isel.tictactoe.components.Button
import pt.isel.tictactoe.components.Leaderboard

@Page("/")
fun home() =
    Div(
        attributes = Attribute.id("container")
    ) {
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
    }
