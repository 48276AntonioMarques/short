package pt.isel.tictactoe.page

import pt.isel.SHORT.Page
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.Var
import pt.isel.SHORT.html.attribute.src
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.css.Import
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Script
import pt.isel.tictactoe.component.Game
import pt.isel.tictactoe.element.Button
import pt.isel.tictactoe.element.Center
import pt.isel.tictactoe.element.Line
import pt.isel.tictactoe.element.TopBar

enum class GameMode {
    LOCAL,
    ONLINE
}

@Import("stylesheet", "text/css", "/css/game.css")
@Import("stylesheet", "text/css", "/css/topbar.css")
@Page("/play")
fun Tag.play() = apply {
    GamePage(GameMode.LOCAL)
}

@Import("stylesheet", "text/css", "/css/game.css")
@Import("stylesheet", "text/css", "/css/topbar.css")
@Page("/online")
fun Tag.online() = apply {
    GamePage(GameMode.ONLINE)
}

fun Tag.GamePage(mode: GameMode) = apply {
    val backHandler: EventHandler = {
        // TODO: Ask user if they want to leave the game
        call("navigate", "/")
    }
    Script(attributes = Attribute.src("/js/game.js"))

    Center {
        Line {
            TopBar()
            Button("X", "primary-color-2 back-button", backHandler)
        }
        Game()
        Div {
            Text {
                "It's Player1's turn."
            }
        }
    }
}