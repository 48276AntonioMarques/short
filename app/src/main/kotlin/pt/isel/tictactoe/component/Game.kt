package pt.isel.tictactoe.component

import pt.isel.SHORT.client.Var
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.tictactoe.element.Height
import pt.isel.tictactoe.element.Position
import pt.isel.tictactoe.element.Side
import pt.isel.tictactoe.element.Square

fun Tag.Game() = apply {

    val nextPiece = Var("X")

    Div(
        Attribute.`class`("board")
    ){
        Div(
            Attribute.`class`("row")
        ) {
            Square(Position(Height.TOP, Side.LEFT), nextPiece)
            Square(Position(Height.TOP, Side.CENTER), nextPiece)
            Square(Position(Height.TOP, Side.RIGHT), nextPiece)
        }
        Div(
            Attribute.`class`("row")
        ) {
            Square(Position(Height.CENTER, Side.LEFT), nextPiece)
            Square(Position(Height.CENTER, Side.CENTER), nextPiece)
            Square(Position(Height.CENTER, Side.RIGHT), nextPiece)
        }
        Div(
            Attribute.`class`("row")
        ) {
            Square(Position(Height.BOTTOM, Side.LEFT), nextPiece)
            Square(Position(Height.BOTTOM, Side.CENTER), nextPiece)
            Square(Position(Height.BOTTOM, Side.RIGHT), nextPiece)
        }
    }
}