package pt.isel.tictactoe

import pt.isel.SHORT.Application
import pt.isel.SHORT.html.HtmlTag
import pt.isel.SHORT.runSHORT

class TicTacToeApp : Application() {
    override fun getLoadingScreen(root: HtmlTag) = root.loadingScreen()
}

fun main(args: Array<String>) {
    runSHORT<TicTacToeApp>(args)
}
