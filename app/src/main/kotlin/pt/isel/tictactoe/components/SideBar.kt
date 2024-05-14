package pt.isel.tictactoe.components

import pt.isel.SHORT.component.Component
import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.element.Div

@Component
fun Tag.SideBar() = apply {
    Div(attributes = Attribute.`class`("sidebar")) {
        val leafCount = 7
        for (i in 0 until leafCount) {
            val numOfColors = 5
            val mod = numOfColors * 2 - 2

            val colorNumber = if (i % mod < numOfColors) i % mod + 1 else mod - i % mod + 1
            Div(attributes = Attribute.`class`("leaf primary-color-$colorNumber"))
        }
    }
}
