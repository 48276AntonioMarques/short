package pt.isel.tictactoe.element

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.get
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
    fun toIndex(): Int {
        val height = when (height) {
            Height.CENTER -> 3
            Height.BOTTOM -> 6
            else -> 0
        }
        val side = when (side) {
            Side.CENTER -> 1
            Side.RIGHT -> 2
            else -> 0
        }
        return height + side
    }
}

fun Tag.Square(onClick: EventHandler, position: Position) = apply {
    val bgColor = position.toColor()
    val height = position.height.toString().lowercase()
    val side = position.side.toString().lowercase()

    Div(
        Attribute.`class`("square $bgColor square-$height square-$side preview-x").onclick(onClick)
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
