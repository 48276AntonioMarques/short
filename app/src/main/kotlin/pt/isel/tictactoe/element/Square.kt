package pt.isel.tictactoe.element

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.Var
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.client.compare
import pt.isel.SHORT.client.equal
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.event.onclick

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

data class Position(val height: Height, val side: Side)

fun Tag.Square(position: Position, nextPiece: Variable<String>) = apply {

    val bgColor = when {
        position.height == Height.CENTER -> {
            if (position.side == Side.CENTER) {
                "bg-color-1"
            } else {
                "bg-color-2"
            }
        }
        else -> {
            if (position.side == Side.CENTER) {
                "bg-color-2"
            } else {
                "bg-color-1"
            }
        }
    }

    val height = when (position.height) {
        Height.TOP -> "top"
        Height.CENTER -> "center"
        Height.BOTTOM -> "bottom"
    }

    val side = when (position.side) {
        Side.LEFT -> "left"
        Side.CENTER -> "center"
        Side.RIGHT -> "right"
    }

    val handleClick: EventHandler = {
        val x = Var("X")
        compare(nextPiece equal x, {
            set(nextPiece, "O")
            call("setPiece", "X", position.height.toString(), position.side.toString())
        }) {
            set(nextPiece, "X")
            call("setPiece", "O", position.height.toString(), position.side.toString())
        }
        console.log(nextPiece)
    }

    Div(
        Attribute.`class`("square $bgColor square-$height square-$side preview-x").onclick(handleClick)
    ){
        Div(
            Attribute.`class`("preview")
        ) {
            Text {
                "X"
            }
        }
    }
}