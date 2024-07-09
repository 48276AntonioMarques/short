package pt.isel.tictactoe.game

import pt.isel.SHORT.client.Variable
import pt.isel.tictactoe.service.remote.User

enum class GameSide { X, O }

data class Player(
    private val user: User,
    private val side: GameSide
) {
    val username: String = user.name
}

interface IGame

class NoGame : IGame

data class Game(
    private val player1: Variable<Player>,
    private val player2: Variable<Player>
)
