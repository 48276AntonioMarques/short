package pt.isel.tictactoe.game

import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.client.Var
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.client.compare
import pt.isel.SHORT.client.during
import pt.isel.SHORT.client.equal
import pt.isel.SHORT.client.get
import pt.isel.SHORT.client.lessThan
import pt.isel.SHORT.client.lessThanOrEqual
import pt.isel.SHORT.client.notEqual
import pt.isel.SHORT.client.switch
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.tictactoe.element.Position
import pt.isel.tictactoe.service.remote.User

enum class GameSide { X, O }
enum class SquareContent { X, O, EMPTY }
enum class GameState { X_TURN, O_TURN, X_WIN, O_WIN, DRAW }

data class Player(
    private val user: User,
    private val side: GameSide
) {
    val username: String = user.name
}

interface IGame

class NoGame : IGame

typealias Board = Array<SquareContent>
data class Line(val a: Int, val b: Int, val c: Int)

data class Piece(val position: Position, val content: GameSide)

/**
 * Represents a game of Tic Tac Toe.
 * This contains the representation of all the state of the game.
 * The logic for this game is based on: [poggersbot tiktactoe](https://github.com/48276AntonioMarques/pogersbot/blob/main/modules/tiktoktoe.js)
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
    private val winner: GameState = GameState.X_TURN

    val nextPiece: SquareContent = SquareContent.X
    val leftRounds: Int = 9

    companion object {
        fun makeMove(tag: Tag, script: JavaScript, game: Variable<Game>, index: Int) {
            tag.apply {
                script.apply {
                    // Check if the game is over
                    val winState = Var(GameState.X_TURN)
                    getField(game.field<Game, GameState>("winner"), winState)
                    val xWon = Var(GameState.X_WIN)
                    val oWon = Var(GameState.O_WIN)
                    compare(
                        winState notEqual xWon then {
                            compare(
                                winState notEqual oWon then {
                                    // Check if the square is empty
                                    val i = Var(index)
                                    set(i, index)
                                    val board = Var(Board(9) { SquareContent.EMPTY })
                                    set(board, Board(9) { SquareContent.EMPTY })
                                    getField(game.field<Game, Board>("board"), board)
                                    val square = Var(SquareContent.EMPTY)
                                    set(square, SquareContent.EMPTY)
                                    Array.get(square, board[i])
                                    val emptySquare = Var(SquareContent.EMPTY)
                                    compare(
                                        square equal emptySquare then {
                                            // Place piece
                                            val nextPiece = Var(SquareContent.X)
                                            getField(game.field<Game, SquareContent>("nextPiece"), nextPiece)
                                            Array.set(board[i], nextPiece)
                                            val leftRounds = Var(9)
                                            getField(game.field<Game, Int>("leftRounds"), leftRounds)
                                            decrement(leftRounds)
                                            setField(game.field<Game, Int>("leftRounds"), leftRounds)
                                            call("renderPiece", i, nextPiece)
                                            // Check if the game is over
                                            val winner = Var(GameState.X_TURN)
                                            set(winner, GameState.X_TURN)
                                            checkWinner(tag, this, game, winner)
                                            switch(winner) {
                                                caseContinuous(GameState.X_WIN) { }
                                                caseContinuous(GameState.O_WIN) { }
                                                case(GameState.DRAW) {
                                                    setField(game.field<Game, GameState>("winner"), winner)
                                                    set(nextPiece, SquareContent.EMPTY)
                                                    setField(game.field<Game, SquareContent>("nextPiece"), nextPiece)
                                                    call("removePreviewHover")
                                                }
                                                default {
                                                    // Update nextPiece
                                                    val x = Var(SquareContent.X)
                                                    compare(
                                                        nextPiece equal x then {
                                                            set(nextPiece, SquareContent.O)
                                                        }
                                                            otherwise {
                                                                set(nextPiece, SquareContent.X)
                                                            }
                                                    )
                                                    setField(game.field<Game, SquareContent>("nextPiece"), nextPiece)
                                                }
                                            }
                                            compare(
                                                winner notEqual xWon then {
                                                    compare(
                                                        winner notEqual oWon then {
                                                        }
                                                            otherwise {
                                                            }
                                                    )
                                                }
                                                    otherwise {
                                                        setField(game.field<Game, GameState>("winner"), winner)
                                                        set(nextPiece, SquareContent.EMPTY)
                                                        setField(game.field<Game, SquareContent>("nextPiece"), nextPiece)
                                                        call("removePreviewHover")
                                                    }
                                            )
                                            call("updatePreviews", nextPiece)
                                            updateText(tag, this, game)
                                        }
                                    )
                                }
                            )
                        }
                    )
                }
            }
        }

        private fun checkWinner(tag: Tag, script: JavaScript, game: Variable<Game>, winner: Variable<GameState>) {
            tag.apply {
                script.apply {
                    val winningConditions = Var(Array(1) { Line(0, 0, 0) })
                    getField(game.field<Game, Array<Line>>("winningConditions"), winningConditions)
                    val board = Var(Board(9) { SquareContent.EMPTY })
                    getField(game.field<Game, Board>("board"), board)
                    val iterator = Var(0)
                    set(iterator, 0)
                    val wcSize = Var(8)
                    set(wcSize, 8)
                    during(iterator lessThan wcSize) {
                        val condition = Var(Line(0, 0, 0))
                        Array.get(condition, winningConditions[iterator])
                        val a = Var(0)
                        getField(condition.field<Line, Int>("a"), a)
                        val squareA = Var(SquareContent.EMPTY)
                        Array.get(squareA, board[a])
                        val emptySquare = Var(SquareContent.EMPTY)
                        // game.board[first] != EMPTY
                        compare(
                            squareA notEqual emptySquare then {
                                val b = Var(0)
                                getField(condition.field<Line, Int>("b"), b)
                                val squareB = Var(SquareContent.EMPTY)
                                Array.get(squareB, board[b])
                                // game.board[first] == game.board[second]
                                compare(
                                    squareA equal squareB then {
                                        getField(condition.field<Line, Int>("c"), b)
                                        Array.get(squareB, board[b])
                                        // game.board[first] == game.board[third]
                                        compare(
                                            squareA equal squareB then {
                                                val x = Var(SquareContent.X)
                                                compare(
                                                    squareA equal x then {
                                                        set(winner, GameState.X_WIN)
                                                    }
                                                        otherwise {
                                                            set(winner, GameState.O_WIN)
                                                        }
                                                )
                                            }
                                        )
                                    }
                                )
                            }
                        )

                        increment(iterator)
                    }
                    val xWon = Var(GameState.X_WIN)
                    compare(
                        winner notEqual xWon then {
                            val oWon = Var(GameState.O_WIN)
                            compare(
                                winner notEqual oWon then {
                                    val leftRounds = Var(9)
                                    getField(game.field<Game, Int>("leftRounds"), leftRounds)
                                    val zero = Var(0)
                                    compare(
                                        leftRounds lessThanOrEqual zero then {
                                            set(winner, GameState.DRAW)
                                        }
                                    )
                                }
                            )
                        }
                    )
                }
            }
        }

        fun updateText(tag: Tag, script: JavaScript, game: Variable<Game>) {
            tag.apply {
                script.apply {
                    val winner = Var(GameState.X_TURN)
                    getField(game.field<Game, GameState>("winner"), winner)
                    val player = Var(Player(User("user", "pwd"), GameSide.X))
                    val username = Var("")
                    val text = Var("")
                    set(text, "")
                    val suffix = Var(" wins!")
                    switch(winner) {
                        case(GameState.X_WIN) {
                            getField(game.field<Game, Player>("player1"), player)
                            getField(player.field<Player, String>("username"), username)
                            concat(text, username)
                            concat(text, suffix)
                        }
                        case(GameState.O_WIN) {
                            getField(game.field<Game, Player>("player2"), player)
                            getField(player.field<Player, String>("username"), username)
                            concat(text, username)
                            concat(text, suffix)
                        }
                        case(GameState.DRAW) {
                            set(text, "It's a tie!")
                        }
                        default {
                            val nextPlayer = Var("")
                            val nextPiece = Var(SquareContent.X)
                            getField(game.field<Game, SquareContent>("nextPiece"), nextPiece)
                            val xPiece = Var(SquareContent.X)
                            compare(
                                nextPiece equal xPiece then {
                                    getField(game.field<Game, Player>("player1"), player)
                                }
                                    otherwise {
                                        getField(game.field<Game, Player>("player2"), player)
                                    }
                            )
                            getField(player.field<Player, String>("username"), username)
                            set(nextPlayer, username)
                            val prefix = Var("It's ")
                            val suffix2 = Var("'s turn")
                            concat(text, prefix)
                            concat(text, nextPlayer)
                            concat(text, suffix2)
                        }
                    }
                    call("renderText", text)
                }
            }
        }
    }
}
