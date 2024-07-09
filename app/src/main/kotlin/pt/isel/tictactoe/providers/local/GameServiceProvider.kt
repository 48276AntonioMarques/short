package pt.isel.tictactoe.providers.local

import pt.isel.SHORT.html.base.element.HtmlScope
import pt.isel.tictactoe.service.local.GameService
import pt.isel.tictactoe.service.local.RealGameService

interface GameServiceProvider {
    val gameService: GameService
}

class RealGameServiceProvider(getScope: () -> HtmlScope) : GameServiceProvider {
    override val gameService: GameService by lazy { RealGameService(getScope()) }
}
