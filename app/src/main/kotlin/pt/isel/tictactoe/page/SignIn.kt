package pt.isel.tictactoe.page

import pt.isel.SHORT.Page
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Input
import pt.isel.tictactoe.element.Button
import pt.isel.tictactoe.element.Center
import pt.isel.tictactoe.element.Menu
import pt.isel.tictactoe.element.MenuLine
import pt.isel.tictactoe.element.SideBar
import pt.isel.tictactoe.element.Title

@Page("/sign")
fun Tag.SignIn() = apply {
    SideBar()
    Center {
        Title("Tic Tac Toe")
        Menu {
            /*
            val username = Var("")
            val password = Var("")
            val pwdCheck = Var("")

            fun genOnChange(variable: Variable<String>): EventHandler = { variable.setValue(event.target.value) }

            val onUsernameChange = genOnChange(username)
            val onPasswordChange = genOnChange(password)
            val onPwdCheckChange = genOnChange(pwdCheck)

            val signIn: EventHandler = {
                console.log(username.value)
                console.log(password.value)
                console.log(pwdCheck.value)
            }
            */
            val back: EventHandler = {
                // Should this do history.back(1) instead?
                call("navigate", "/")
            }

            Div(Attribute.`class`("input-container secondary-color-5")) {
                Text { "Username:" }
                Input(/*Attribute.onchange(onUsernameChange)*/)
            }
            Div(Attribute.`class`("input-container secondary-color-4")) {
                Text { "Password:" }
                Input(/*Attribute.onchange(onPasswordChange)*/)
            }
            Div(Attribute.`class`("input-container secondary-color-3")) {
                Text { "Verify Password:" }
                Input(/*Attribute.onchange(onPwdCheckChange)*/)
            }
            MenuLine("line-65") {
                Button("SIGN IN", "secondary-color-2"/*, signIn*/)
                Button("BACK", "secondary-color-1", back)
            }
        }
    }
    SideBar()
}
