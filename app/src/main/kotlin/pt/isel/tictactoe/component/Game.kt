package pt.isel.tictactoe.component

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.client.get
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.base.Script
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.tictactoe.element.Height
import pt.isel.tictactoe.element.Position
import pt.isel.tictactoe.element.Side
import pt.isel.tictactoe.element.Square
import pt.isel.tictactoe.game.Game

fun Tag.Game(game: Variable<Game>) = apply {
    fun genOnClick(index: Int): EventHandler = {
        Game.makeMove(this@Game, this, game, index)
    }
    Script {
        Game.updateText(this@Game, this, game)
    }
    Div(
        Attribute.`class`("board")
    ) {
        for (height in Height.entries) {
            Div(
                Attribute.`class`("row")
            ) {
                for (side in Side.entries) {
                    val position = Position(height, side)
                    Square(genOnClick(position.toIndex()), position)
                }
            }
        }
    }
}
