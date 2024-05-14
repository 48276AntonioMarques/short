package pt.isel.tictactoe.pages

import pt.isel.SHORT.Page
import pt.isel.SHORT.css.Import
import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Text
import pt.isel.tictactoe.components.Button
import pt.isel.tictactoe.components.MainMenu
import pt.isel.tictactoe.components.SideBar
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Import("stylesheet", "text/css", "/css/fonts.css")
@Import("stylesheet", "text/css", "/css/color.css")
@Import("stylesheet", "text/css", "/css/styles.css")
@Page("/")
fun Tag.home() = apply {
    SideBar()
    MainMenu()
    SideBar()
}
