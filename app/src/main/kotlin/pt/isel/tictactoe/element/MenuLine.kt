package pt.isel.tictactoe.element

import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div

fun Tag.MenuLine(block: Tag.() -> Unit) = apply {
    Div(Attribute.`class`("menu-line")) {
        block()
    }
}
