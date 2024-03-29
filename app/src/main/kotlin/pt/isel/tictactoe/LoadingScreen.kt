package pt.isel.tictactoe

import pt.isel.SHORT.html.HtmlTag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Img
import pt.isel.SHORT.html.element.Style

fun HtmlTag.loadingScreen() =
    Div {
        Style("loading.css")
        Img("loading.gif", embed = true)
    }
