package pt.isel.tictactoe.component

import pt.isel.SHORT.component.Component
import pt.isel.SHORT.html.attribute.id
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div

@Component
fun Tag.Leaderboard() =
    Div(
        attributes = Attribute.id("leaderboard")
    ) {
        Text("Leaderboard")
    }
