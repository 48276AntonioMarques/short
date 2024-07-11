package pt.isel.tictactoe.element

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.event.onclick
import pt.isel.tictactoe.game.Game

enum class Height {
    TOP,
    CENTER,
    BOTTOM
}

enum class Side {
    LEFT,
    CENTER,
    RIGHT
}

data class Position(val height: Height, val side: Side) {
    fun toColor(): String = when {
        height == Height.CENTER -> {
            if (side == Side.CENTER) {
                "bg-color-1"
            } else {
                "bg-color-2"
            }
        }
        else -> {
            if (side == Side.CENTER) {
                "bg-color-2"
            } else {
                "bg-color-1"
            }
        }
    }
}

fun Tag.Square(game: Variable<Game>, position: Position) = apply {
    val bgColor = position.toColor()
    val height = position.height.toString().lowercase()
    val side = position.side.toString().lowercase()

    val handleClick: EventHandler = { call("setPiece", game, position) }

    Div(
        Attribute.`class`("square $bgColor square-$height square-$side preview-x").onclick(handleClick)
    ) {
        Div(
            Attribute.`class`("preview")
        ) {
            Text {
                "X"
            }
        }
    }
}
