package pt.isel.tictactoe.service.local

import pt.isel.SHORT.client.Var
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.client.compare
import pt.isel.SHORT.client.equal
import pt.isel.SHORT.client.get
import pt.isel.SHORT.html.base.Script
import pt.isel.SHORT.html.base.element.HtmlScope
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.tictactoe.game.Game
import pt.isel.tictactoe.game.GameSide
import pt.isel.tictactoe.game.IGame
import pt.isel.tictactoe.game.NoGame
import pt.isel.tictactoe.game.Player
import pt.isel.tictactoe.service.remote.User

interface GameService {
    fun createGame(tag: Tag, player1: Variable<Player>, player2: Variable<Player>): Variable<IGame>
    fun destroyGame(tag: Tag)
}

class RealGameService(htmlScope: HtmlScope) : GameService {
    // For this purpose all the services should inherit from some class
    // That class should allow to register variables
    // For this service to hold a state that state must be static and a SHORT Variable
    private val tagContext = htmlScope.html.tag
    private val noGame = tagContext.Var(NoGame()) as Variable<IGame>
    private var game: Variable<IGame> = noGame

    // This is meant to execute on the client when creating a new game
    // The server should not be able to create a game
    // This structure will not work for that purpose
    override fun createGame(tag: Tag, player1: Variable<Player>, player2: Variable<Player>): Variable<IGame> {
        tag.apply {
            val newGame: Variable<IGame> = Var(NoGame())
            Script {
                compare(
                    game equal noGame
                        then {
                            val createGame = Var(
                                Game(
                                    tag,
                                    Player(
                                        User("host", ""),
                                        GameSide.X
                                    ),
                                    Player(
                                        User("guest", ""),
                                        GameSide.O
                                    )
                                )
                            ) as Variable<IGame>
                            update(createGame.field<Game, Player>("player1"), player1)
                            update(createGame.field<Game, Player>("player2"), player2)
                            set(game, createGame)
                            set(newGame, createGame)
                        }
                        otherwise {
                            console.error("Game already exists")
                            console.log(game)
                        }
                )
            }
            return newGame
        }
    }

    override fun destroyGame(tag: Tag) {
        tag.apply {
            Script {
                set(game, noGame)
            }
        }
    }
}
