package pt.isel.tictactoe.element

import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div

fun Tag.Title(title: String) = apply {
    Div(Attribute.`class`("title")) {
        Div(Attribute.`class`("title-text")) {
            Text(title)
        }
        Div(Attribute.`class`("title-bar"))
    }
}
