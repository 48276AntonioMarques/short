package pt.isel.tictactoe.service.local

import pt.isel.SHORT.client.Var
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.comms.serverCall
import pt.isel.SHORT.html.base.Script
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.tictactoe.service.remote.Leaderboard
import pt.isel.tictactoe.service.remote.ScoreRepository

interface ScoreService {
    fun getLeaderboard(tag: Tag, page: Variable<Page>): Variable<Leaderboard>
}

data class Page(val number: Int, val size: Int)

class RealScoreService : ScoreService {
    override fun getLeaderboard(tag: Tag, page: Variable<Page>): Variable<Leaderboard> {
        val table = tag.Var(Leaderboard(listOf()))
        tag.Script {
            serverCall(table, page) { pageValue ->
                ScoreRepository.getLeaderboard(pageValue.number, pageValue.size)
            }
        }
        return table
    }
}
