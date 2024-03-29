package pt.isel.tictactoe.components

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlTag
import pt.isel.SHORT.html.`class`
import pt.isel.SHORT.html.element.Div

fun HtmlTag.SideBar() = apply {
    Div(attributes = Attribute.`class`("sidebar")) {
        val leafCount = 10
        for (i in 0 until leafCount) {
            Div(attributes = Attribute.`class`("leaf"))
        }
    }
}
