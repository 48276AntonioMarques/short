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
    val signIn: EventHandler = {
        console.log("Signing in...")
        call("navigate", "/sign")
    }

    Center {
        Title("Tic Tac Toe")
        Menu {
            Button("PLAY", "secondary-color-5")
            MenuLine() {
                Button("SIGN IN", "secondary-color-4", signIn)
                Button("LOG IN", "secondary-color-3")
            }
            Button("LEADERBOARD", "secondary-color-2")
            Button("...", "secondary-color-1")
        }
    }
}
