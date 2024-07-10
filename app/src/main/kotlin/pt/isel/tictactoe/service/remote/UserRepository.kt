package pt.isel.tictactoe.service.remote

import pt.isel.tictactoe.service.remote.UserRepository.authenticate

typealias Username = String
typealias Token = String

data class User(val name: Username, val pwdHash: String, var token: Token = "")

object UserRepository {
    internal val users = mutableMapOf<Username, User>(
        "admin" to User("admin", hashPwd("admin")),
        "ethel" to User("ethel", hashPwd("sillysilk63")),
        "jose" to User("jose", hashPwd("braveworm29")),
        "luis" to User("luis", hashPwd("freshshow28")),
        "marta" to User("marta", hashPwd("fuzzysand70"))
    )

    fun addUser(user: User) {
        if (users.containsKey(user.name)) {
            throw IllegalArgumentException("User already exists")
        }
        users[user.name] = user
    }

    fun hashPwd(pwd: String): String {
        return pwd.map { c -> (c.code + 3).toChar() }.joinToString("")
    }

    private fun generateToken(): Token {
        val validChars = ('0'..'9') + ('A'..'Z') + ('a'..'z')
        var token: String
        do {
            // Generate a random token
            token = (1..32).map { validChars.random() }.joinToString("")
        } while (users.any { entry -> entry.value.token == token })
        return token
    }

    fun authenticate(user: User): Token {
        val remoteUser = users[user.name] ?: return ""
        val hash = hashPwd(user.pwdHash)
        return if (hash == remoteUser.pwdHash) {
            generateToken().also { token -> users[user.name]!!.token = token }
        } else {
            ""
        }
    }
}

fun createUser(user: User): Token {
    // Hashing the password storing decreases the effectiveness of a database leak
    val hash = UserRepository.hashPwd(user.pwdHash)

    try {
        println("Adding user: User(${user.name}, $hash)")
        UserRepository.addUser(User(user.name, hash))
    } catch (e: IllegalArgumentException) {
        return ""
    }
    return authenticate(user)
}
