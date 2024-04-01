package pt.isel.tictactoe

import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Img

fun Tag.loadingScreen() =
    Div {
        // Style("loading.css")
        Img("loading.gif", embed = true)
    }
