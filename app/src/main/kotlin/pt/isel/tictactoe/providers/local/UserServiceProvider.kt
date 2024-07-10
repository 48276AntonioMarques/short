package pt.isel.tictactoe.providers.local

import pt.isel.tictactoe.service.local.RealUserService
import pt.isel.tictactoe.service.local.UserService

interface UserServiceProvider {
    val userService: UserService
}

class RealUserServiceProvider() : UserServiceProvider {
    override val userService: UserService by lazy { RealUserService() }
}
