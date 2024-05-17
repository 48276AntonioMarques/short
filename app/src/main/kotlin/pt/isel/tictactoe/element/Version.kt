package pt.isel.tictactoe.element

import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.element.Tag
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun Tag.Version() = apply {
    Text {
        "Bundled at ${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}"
    }
}
