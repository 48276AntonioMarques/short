package pt.isel.tictactoe.game

import pt.isel.SHORT.client.get
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.tictactoe.element.Position
import pt.isel.tictactoe.service.remote.User

enum class GameSide { X, O }
enum class SquareContent { X, O, EMPTY }

data class Player(
    private val user: User,
    private val side: GameSide
) {
    val username: String = user.name
}

interface IGame

class NoGame : IGame

typealias Board = Array<SquareContent>
typealias Line = Triple<Int, Int, Int>

data class Piece(val position: Position, val content: GameSide)

/**
 * Represents a game of Tic Tac Toe.
 * This contains the representation of all the state of the game.
 * The actual game logic is implemented in "game.js" file.
 */
class Game(
    tag: Tag,
    private val player1: Player,
    private val player2: Player
) {
    private val winningConditions: Array<Line> = arrayOf(
        Line(0, 1, 2),
        Line(3, 4, 5),
        Line(6, 7, 8),
        Line(0, 3, 6),
        Line(1, 4, 7),
        Line(2, 5, 8),
        Line(0, 4, 8),
        Line(2, 4, 6)
    )

    private val board: Board = Array(9) { SquareContent.EMPTY }
    private val winner: SquareContent = SquareContent.EMPTY

    val nextPiece: String = "X"
    val leftRounds: Int = 9
}
