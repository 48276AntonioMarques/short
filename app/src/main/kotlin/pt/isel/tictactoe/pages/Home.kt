package pt.isel.tictactoe.pages

import pt.isel.SHORT.Page
import pt.isel.SHORT.component.Var
import pt.isel.SHORT.html.Text
import pt.isel.SHORT.html.element.single.Div

@Page("/")
fun home() =
    Div {
        val name = Var("World")
        Text { "Hello, World!" }
    }
