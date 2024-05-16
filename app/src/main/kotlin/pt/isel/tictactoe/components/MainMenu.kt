package pt.isel.tictactoe.components

import pt.isel.SHORT.component.Component
import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.Text
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.element.Div
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
fun Tag.MainMenu() = apply {
    Div(
        attributes = Attribute.`class`("center")
    ) {
        Div(
            attributes = Attribute.`class`("title")
        ) {
            Div(
                attributes = Attribute.`class`("title-text")
            ) {
                Text("Tic Tac Toe")
            }
            Div(
                attributes = Attribute.`class`("title-bar")
            )
        }
        Div(
            attributes = Attribute.`class`("menu")
        ) {
            Button("PLAY", "secondary-color-5")
            Div(
                attributes = Attribute.`class`("menu-line")
            ) {
                Button("SIGN IN", "secondary-color-4")
                Button("LOG IN", "secondary-color-3")
            }
            Button("LEADERBOARD", "secondary-color-2")
            Button("...", "secondary-color-1")
        }
        Text {
            "Bundled at ${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}"
        }
    }
}
