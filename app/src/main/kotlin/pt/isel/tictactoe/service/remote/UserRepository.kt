package pt.isel.tictactoe.service.remote

typealias Username = String

data class User(val name: Username, val pwdHash: String)

object UserRepository {
    private val users = mutableMapOf<Username, User>()

    fun addUser(user: User) {
        if (users.containsKey(user.name)) {
            throw IllegalArgumentException("User already exists")
        }
        users[user.name] = user
    }

    fun hashPwd(pwd: String): String {
        return pwd
    }
}

fun createUser(user: User): String {
    // Hashing the password storing decreases the effectiveness of a database leak
    val hash = UserRepository.hashPwd(user.pwdHash)

    try {
        println("Adding user: User(${user.name}, $hash)")
        UserRepository.addUser(User(user.name, hash))
    } catch (e: IllegalArgumentException) {
        return "User already exists"
    }
    return "success"
}
