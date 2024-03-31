package pt.isel.tictactoe.pages

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Style
import pt.isel.SHORT.html.element.Text
import pt.isel.tictactoe.components.Button
import pt.isel.tictactoe.components.SideBar
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Page("/")
fun Tag.home() = apply {
    Div(
        attributes = Attribute.`class`("menu align-right")
    ) {
        SideBar()
        Div(
            attributes = Attribute.`class`("content")
        ) {
            Div(attributes = Attribute.`class`("title")) {
                Text("Tic Tac Toe")
            }
            Div(attributes = Attribute.`class`("menu-buttons")) {
                Button("PLAY")
                Div {
                    Button("SIGN IN")
                    Button("LOG IN")
                }
                Button("LEADERBOARD")
                Button("...")
            }
            Text {
                "Bundled at ${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}"
            }
        }
        SideBar()
    }
    Style("/css/styles.css")
    Style("http://online-fonts.com/sites/default/files/css/css_FjK2FbyVynhbQbZZ9qcrvQ8TlBGq_P7UJPLEzp3bt9o.css?delta=0&amp;language=en&amp;theme=fontsonline_theme&amp;include=eJx9zEEKwCAMBdELWTySRE01oIn0pwtv3-4L3Q6PwYbzjJnA4TR1mA5RTt55cmzDMo0Dvt_YfkC5ZDlCoeWl03c3rd6Do6h4ogpW8AOhvjBl")
}
