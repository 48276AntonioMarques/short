package pt.isel.tictactoe.service.local

import pt.isel.SHORT.client.Var
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.client.compare
import pt.isel.SHORT.client.equal
import pt.isel.SHORT.html.base.element.HtmlScope
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Script
import pt.isel.tictactoe.game.Game
import pt.isel.tictactoe.game.IGame
import pt.isel.tictactoe.game.NoGame
import pt.isel.tictactoe.game.Player

interface GameService {
    fun createGame(tag: Tag, player1: Variable<Player>, player2: Variable<Player>): Variable<IGame>
}

class RealGameService(htmlScope: HtmlScope) : GameService {
    // For this purpose all the services should inherit from some class
    // That class should allow to register variables
    // For this service to hold a state that state must be static and a SHORT Variable
    private val tagContext = htmlScope.html.tag
    private var game: Variable<IGame> = tagContext.Var(NoGame())

    // This is meant to execute on the client when creating a new game
    // The server should not be able to create a game
    // This structure will not work for that purpose
    override fun createGame(tag: Tag, player1: Variable<Player>, player2: Variable<Player>): Variable<IGame> {
        tag.apply {
            val newGame: Variable<IGame> = Var(NoGame())
            Script {
                val noGame = Var(NoGame()) as Variable<IGame>
                compare(
                    game equal noGame
                        then {
                            val createGame = Var(Game(player1, player2)) as Variable<IGame>
                            set(game, createGame)
                            set(newGame, createGame)
                        }
                        otherwise {
                            console.log("Game already exists")
                        }
                )
            }
            return newGame
        }
    }
}
