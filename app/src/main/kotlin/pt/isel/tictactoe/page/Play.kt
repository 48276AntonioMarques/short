package pt.isel.tictactoe.page

import pt.isel.SHORT.Page
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.Var
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.html.attribute.id
import pt.isel.SHORT.html.attribute.src
import pt.isel.SHORT.html.base.Script
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.css.Import
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.tictactoe.DependenciesProvider
import pt.isel.tictactoe.component.Game
import pt.isel.tictactoe.element.Button
import pt.isel.tictactoe.element.Center
import pt.isel.tictactoe.element.Line
import pt.isel.tictactoe.element.TopBar
import pt.isel.tictactoe.game.GameSide
import pt.isel.tictactoe.game.IGame
import pt.isel.tictactoe.game.Player
import pt.isel.tictactoe.service.remote.User

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
    // Check if player1 is logged in
    // If continue as player1 and player2
    // If logged continue as [username] and guest
    val player1 = Var(Player(User("user", "pwd"), GameSide.X))
    val guest = Var(Player(User("guest", "guest"), GameSide.O))
    val gameService = (scope.application as DependenciesProvider).gameServiceProvider.gameService
    val game: Variable<IGame> = gameService.createGame(this, player1, guest)
    Script {
        if (mode == GameMode.ONLINE) {
            console.log("Online mode not implemented yet")
            call("navigate", "/")
        }
    }

    val backHandler: EventHandler = {
        gameService.destroyGame(this@GamePage)
        call("navigate", "/")
    }
    Script(attributes = Attribute.src("/js/game.js"))

    Center {
        Line {
            TopBar()
            Button("X", "primary-color-2 back-button", backHandler)
        }
        Game(game)
        Div(Attribute.id("game-text")) {
            Text {
                ""
            }
        }
    }
}
