package pt.isel.tictactoe.providers.local

import pt.isel.tictactoe.service.local.RealScoreService
import pt.isel.tictactoe.service.local.ScoreService

interface ScoreServiceProvider {
    val scoreService: ScoreService
}

class RealScoreServiceProvider : ScoreServiceProvider {
    override val scoreService: ScoreService by lazy { RealScoreService() }
}
