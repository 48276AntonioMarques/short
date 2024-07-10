package pt.isel.tictactoe

import pt.isel.SHORT.Application
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.runSHORT
import pt.isel.tictactoe.providers.local.GameServiceProvider
import pt.isel.tictactoe.providers.local.RealGameServiceProvider
import pt.isel.tictactoe.providers.local.RealScoreServiceProvider
import pt.isel.tictactoe.providers.local.RealUserServiceProvider
import pt.isel.tictactoe.providers.local.ScoreServiceProvider
import pt.isel.tictactoe.providers.local.UserServiceProvider

interface DependenciesProvider {
    val gameServiceProvider: GameServiceProvider
    val userServiceProvider: UserServiceProvider
    val scoreServiceProvider: ScoreServiceProvider
}

class TicTacToeApp(args: Array<String>) : DependenciesProvider, Application(args) {
    override fun getLoadingScreen(root: Tag) = root.loadingScreen()

    override val gameServiceProvider = RealGameServiceProvider(::getScope)
    override val userServiceProvider = RealUserServiceProvider()
    override val scoreServiceProvider = RealScoreServiceProvider()
}

fun main(args: Array<String>) {
    runSHORT<TicTacToeApp>(args)
}
