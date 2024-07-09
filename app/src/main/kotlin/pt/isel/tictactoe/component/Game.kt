package pt.isel.tictactoe.component

import pt.isel.SHORT.client.Var
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.tictactoe.DependenciesProvider
import pt.isel.tictactoe.element.Height
import pt.isel.tictactoe.element.Position
import pt.isel.tictactoe.element.Side
import pt.isel.tictactoe.element.Square
import pt.isel.tictactoe.game.GameSide
import pt.isel.tictactoe.game.IGame
import pt.isel.tictactoe.game.Player
import pt.isel.tictactoe.service.remote.User

fun Tag.Game() = apply {
    // Check if player1 is logged in
    // If continue as player1 and player2
    // If logged continue as [username] and guest
    val player1 = Var(Player(User("user", "pwd"), GameSide.X))
    val guest = Var(Player(User("guest", "guest"), GameSide.O))
    val gameService = (scope.application as DependenciesProvider).gameServiceProvider.gameService
    val game: Variable<IGame> = gameService.createGame(this, player1, guest)
    val nextPiece = Var("X")

    Div(
        Attribute.`class`("board")
    ) {
        for (height in Height.entries) {
            Div(
                Attribute.`class`("row")
            ) {
                for (side in Side.entries) {
                    Square(Position(height, side), nextPiece)
                }
            }
        }
    }
}
