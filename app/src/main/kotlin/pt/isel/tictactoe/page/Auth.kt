package pt.isel.tictactoe.page

import pt.isel.SHORT.Page
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.component.Var
import pt.isel.SHORT.component.Variable
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.tictactoe.element.AuthLine
import pt.isel.tictactoe.element.Center
import pt.isel.tictactoe.element.InputLine
import pt.isel.tictactoe.element.Menu
import pt.isel.tictactoe.element.SideBar
import pt.isel.tictactoe.element.Title

@Page("/sign")
fun Tag.SignUp() = apply {
    AuthPage(AuthOption.SIGN_UP)
}

@Page("/login")
fun Tag.LogIn() = apply {
    AuthPage(AuthOption.LOG_IN)
}

enum class AuthOption {
    SIGN_UP,
    LOG_IN
}

fun Tag.AuthPage(option: AuthOption) = apply {
    SideBar()
    Center {
        Title("Tic Tac Toe")
        Menu {
            val username = Var("")
            val password = Var("")
            val pwdCheck = Var("")

            fun genOnChange(variable: Variable<String>): EventHandler = { variable.setValue(event.target.value) }

            val onUsernameChange = genOnChange(username)
            val onPasswordChange = genOnChange(password)
            val onPwdCheckChange = genOnChange(pwdCheck)

            val signUp: EventHandler = {
                console.log(username.value)
                console.log(password.value)
                console.log(pwdCheck.value)
            }

            val logIn: EventHandler = {
                console.log(username.value)
                console.log(password.value)
            }

            val action = when (option) {
                AuthOption.SIGN_UP -> signUp
                AuthOption.LOG_IN -> logIn
            }

            InputLine("Username:", "secondary-color-5", onUsernameChange)
            // InputLine("Password:", "secondary-color-4", onPasswordChange)

            if (option == AuthOption.SIGN_UP) {
                // InputLine("Verify Password:", "secondary-color-3", onPwdCheckChange)
            }

            AuthLine(option, action)
        }
    }
    SideBar()
}
