package pt.isel.tictactoe.pages

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.base.css.Import
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.tictactoe.components.MainMenu
import pt.isel.tictactoe.components.SideBar

@Import("stylesheet", "text/css", "/css/fonts.css")
@Import("stylesheet", "text/css", "/css/color.css")
@Import("stylesheet", "text/css", "/css/styles.css")
@Page("/")
fun Tag.home() = apply {
    SideBar()
    MainMenu()
    SideBar()
}
