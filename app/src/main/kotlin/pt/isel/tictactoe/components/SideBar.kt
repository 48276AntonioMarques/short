package pt.isel.tictactoe.components

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.element.Div

fun Tag.SideBar() = apply {
    Div(attributes = Attribute.`class`("sidebar")) {
        val leafCount = 10
        for (i in 0 until leafCount) {
            Div(attributes = Attribute.`class`("leaf"))
        }
    }
}
