package pt.isel.tictactoe.component

import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.tictactoe.element.Height
import pt.isel.tictactoe.element.Position
import pt.isel.tictactoe.element.Side
import pt.isel.tictactoe.element.Square
import pt.isel.tictactoe.game.Game
import pt.isel.tictactoe.game.IGame

fun Tag.Game(game: Variable<IGame>) = apply {
    Div(
        Attribute.`class`("board")
    ) {
        for (height in Height.entries) {
            Div(
                Attribute.`class`("row")
            ) {
                for (side in Side.entries) {
                    Square(game as Variable<Game>, Position(height, side))
                }
            }
        }
    }
}
