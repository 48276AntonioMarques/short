package pt.isel.tictactoe.element

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.tictactoe.page.AuthOption

fun Tag.AuthLine(option: AuthOption, action: EventHandler) = apply {
    MenuLine("line-65") {
        val back: EventHandler = { call("navigate", "/") }
        val actionName = if (option == AuthOption.SIGN_UP) "SIGN UP" else "LOG IN"
        Button(actionName, "secondary-color-2", action)
        Button("BACK", "secondary-color-1", back)
    }
}
