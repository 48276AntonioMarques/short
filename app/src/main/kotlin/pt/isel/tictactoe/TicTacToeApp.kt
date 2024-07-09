package pt.isel.tictactoe

import pt.isel.SHORT.Application
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.runSHORT
import pt.isel.tictactoe.providers.local.GameServiceProvider
import pt.isel.tictactoe.providers.local.RealGameServiceProvider

interface DependenciesProvider {
    val gameServiceProvider: GameServiceProvider
}

class TicTacToeApp(args: Array<String>) : DependenciesProvider, Application(args) {
    override fun getLoadingScreen(root: Tag) = root.loadingScreen()

    override val gameServiceProvider = RealGameServiceProvider(::getScope)
}

fun main(args: Array<String>) {
    runSHORT<TicTacToeApp>(args)
}
