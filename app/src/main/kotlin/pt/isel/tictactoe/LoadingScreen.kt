package pt.isel.tictactoe

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.attribute.id
import pt.isel.SHORT.html.attribute.src
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Img
import pt.isel.SHORT.html.element.Style

fun Tag.loadingScreen() =
    Div(
        attributes = Attribute.id("loading-screen")
    ) {
        Style(attributes = Attribute.src("styles/loading.css"))
        Img(attributes = Attribute.src("images/loading.gif"))
    }
