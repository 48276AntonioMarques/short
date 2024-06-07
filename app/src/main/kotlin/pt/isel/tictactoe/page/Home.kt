package pt.isel.tictactoe.page

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.base.css.Import
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.tictactoe.component.MainMenu
import pt.isel.tictactoe.element.SideBar

@Import("stylesheet", "text/css", "/css/fonts.css")
@Import("stylesheet", "text/css", "/css/color.css")
@Import("stylesheet", "text/css", "/css/styles.css")
@Import("stylesheet", "text/css", "/css/sidebar.css")
@Import("stylesheet", "text/css", "/css/menu.css")
@Import("stylesheet", "text/css", "/css/button.css")
@Import("stylesheet", "text/css", "/css/input.css")
@Page("/")
fun Tag.home() = apply {
    SideBar()
    MainMenu()
    SideBar()
}
