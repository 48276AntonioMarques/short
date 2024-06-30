package pt.isel.tictactoe.logic

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.Var
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.client.compare
import pt.isel.SHORT.client.equal
import pt.isel.SHORT.comms.serverCall
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.tictactoe.server.User
import pt.isel.tictactoe.server.createUser

fun <S, T> Tag.signUp(username: Variable<S>, password: Variable<T>, pwdCheck: Variable<T>): EventHandler = {
    compare(
        password equal pwdCheck then {
            console.log("Signing up...")
            val user = Var(User("name", "hash"))
            update(user.field<User>("name"), username)
            update(user.field<User>("pwdHash"), password)

            val result: Variable<String> = Var("Variable not set.")
            serverCall(result, user) { createUser(it) }

            val success = Var("success")
            compare(
                result equal success then {
                    console.log("User created successfully")
                    call("navigate", "/")
                }
                    otherwise {
                        call("alert", result)
                        console.error("Error creating user caused by:")
                        console.log(result)
                    }
            )
        }
            otherwise {
                console.log("Passwords don't match")
            }
    )
}
