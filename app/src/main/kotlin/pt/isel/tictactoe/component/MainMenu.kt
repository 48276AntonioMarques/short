package pt.isel.tictactoe.component

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.component.Component
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.tictactoe.element.Button
import pt.isel.tictactoe.element.Center
import pt.isel.tictactoe.element.Menu
import pt.isel.tictactoe.element.MenuLine
import pt.isel.tictactoe.element.Title

@Component
fun Tag.MainMenu() = apply {
    val play: EventHandler = { call("navigate", "/play") }
    val signUp: EventHandler = { call("navigate", "/sign") }
    val logIn: EventHandler = { call("navigate", "/login") }
    val leaderboard: EventHandler = { call("navigate", "/leaderboard") }
    val about: EventHandler = { call("navigate", "/about") }

    Center {
        Title("Tic Tac Toe")
        Menu {
            Button("PLAY", "secondary-color-5", play)
            MenuLine {
                Button("SIGN IN", "secondary-color-4", signUp)
                Button("LOG IN", "secondary-color-3", logIn)
            }
            Button("LEADERBOARD", "secondary-color-2", leaderboard)
            Button("...", "secondary-color-1", about)
        }
    }
}
