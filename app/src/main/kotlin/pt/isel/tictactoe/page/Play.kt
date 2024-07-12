package pt.isel.tictactoe.page

import pt.isel.SHORT.Page
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.Var
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.client.compare
import pt.isel.SHORT.client.notNull
import pt.isel.SHORT.comms.serverCall
import pt.isel.SHORT.html.attribute.id
import pt.isel.SHORT.html.attribute.src
import pt.isel.SHORT.html.base.Script
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.css.Import
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.tictactoe.element.Button
import pt.isel.tictactoe.element.Center
import pt.isel.tictactoe.element.Line
import pt.isel.tictactoe.element.TopBar
import pt.isel.tictactoe.game.Game
import pt.isel.tictactoe.game.GameSide
import pt.isel.tictactoe.game.Player
import pt.isel.tictactoe.service.remote.User
import pt.isel.tictactoe.service.remote.UserRepository
import pt.isel.tictactoe.component.Game as GameComponent

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
    val gamePrefab = Game(
        this,
        Player(
            User("user", "pwd"),
            GameSide.X
        ),
        Player(
            User("guest", "guest"),
            GameSide.O
        )
    )
    val game: Variable<Game> = Var(gamePrefab)
    val onPageLoad: EventHandler = {
        set(game, gamePrefab)
        when (mode) {
            GameMode.ONLINE -> {
                console.log("Online mode not implemented yet")
                call("navigate", "/")
            }
            GameMode.LOCAL -> {
                // If player1 is logged in set player1 to the logged user
                // If not set player1 to host
                // And set player2 to guest
                val token = Var("token")
                window.sessionStorage.getItem(token, token)
                compare(
                    token.notNull() then {
                        // Player logged in
                        val user: Variable<User?> = Var(User("user", "pwd")) as Variable<User?>
                        // FIXME: This is an asynchronous call inside a <script>
                        serverCall(user, token) { token ->
                            UserRepository.getUser(token)
                        }
                        compare(
                            user.notNull() then {
                                setField(player1.field<Player, User>("user"), user as Variable<User>)
                            }
                        )
                    } otherwise {
                        val host = Var(User("host", "pwd"))
                        setField(player1.field<Player, User>("user"), host)
                    }
                )
                setField(game.field<Game, Player>("player1"), player1)
            }
        }
    }
    Script {
        call(onPageLoad)
    }

    val backHandler: EventHandler = {
        call("navigate", "/")
    }

    Center {
        Line {
            TopBar()
            Button("X", "primary-color-2 back-button", backHandler)
        }
        GameComponent(game)
        Div(Attribute.id("game-text")) {
            Text {
                "It's X's turn!"
            }
        }
        Script(attributes = Attribute.src("/js/game.js")) {
            Game.updateText(this@Center, this, game)
        }
    }
}
