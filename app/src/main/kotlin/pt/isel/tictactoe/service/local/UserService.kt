package pt.isel.tictactoe.service.local

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.client.JsScope
import pt.isel.SHORT.client.Var
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.client.compare
import pt.isel.SHORT.client.equal
import pt.isel.SHORT.client.notEqual
import pt.isel.SHORT.client.notNull
import pt.isel.SHORT.comms.serverCall
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.tictactoe.service.remote.User
import pt.isel.tictactoe.service.remote.UserRepository.authenticate
import pt.isel.tictactoe.service.remote.createUser

interface UserService {
    fun signUp(tag: Tag, username: Variable<String>, password: Variable<String>, pwdCheck: Variable<String>): EventHandler
    fun logIn(tag: Tag, username: Variable<String>, password: Variable<String>): EventHandler
    fun isLoggedIn(tag: Tag, script: JavaScript): Variable<Boolean>
}

class RealUserService : UserService {
    override fun signUp(tag: Tag, username: Variable<String>, password: Variable<String>, pwdCheck: Variable<String>): EventHandler = {
        compare(
            password equal pwdCheck then {
                console.log("Signing up...")
                val user = tag.Var(User("name", "hash"))
                setField(user.field<User, String>("name"), username)
                setField(user.field<User, String>("pwdHash"), password)

                val result: Variable<String> = tag.Var("Variable not set.")
                serverCall(result, user) { createUser(it) }

                val failure = tag.Var("")
                compare(
                    result notEqual failure then {
                        console.log("User created successfully")
                        val token = tag.Var("token")
                        window.sessionStorage.setItem(token, result)
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

    override fun logIn(tag: Tag, username: Variable<String>, password: Variable<String>): EventHandler = {
        console.log("Logging in...")
        val user = tag.Var(User("name", "hash"))
        setField(user.field<User, String>("name"), username)
        setField(user.field<User, String>("pwdHash"), password)

        val result: Variable<String> = tag.Var("")
        serverCall(result, user) { authenticate(it) }

        val emptyString = tag.Var("")
        compare(
            result notEqual emptyString then {
                console.log("Login successful")
                val token = tag.Var("token")
                window.sessionStorage.setItem(token, result)
                call("navigate", "/")
            }
                otherwise {
                    call("alert", "Log in failed!")
                    console.error("Error logging in.")
                }
        )
    }

    override fun isLoggedIn(tag: Tag, script: JavaScript): Variable<Boolean> {
        val result = tag.Var(false)
        JsScope(script) {
            val token = tag.Var("token")
            val output = tag.Var("")
            window.sessionStorage.getItem(output, token)
            compare(
                output.notNull() then {
                    set(result, true)
                }
                    otherwise {
                        set(result, false)
                    }
            )
        }
        return result
    }
}
