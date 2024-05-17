package pt.isel.tictactoe

import pt.isel.SHORT.Application
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.runSHORT

class TicTacToeApp(args: Array<String>) : Application(args) {
    override fun getLoadingScreen(root: Tag) = root.loadingScreen()
}

fun main(args: Array<String>) {
    runSHORT<TicTacToeApp>(args)
}
