package pt.isel.tictactoe.page

import pt.isel.SHORT.Page
import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.Var
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.attribute.src
import pt.isel.SHORT.html.base.Script
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.css.Import
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Table
import pt.isel.SHORT.html.element.Tbody
import pt.isel.SHORT.html.element.Th
import pt.isel.SHORT.html.element.Thead
import pt.isel.SHORT.html.element.Tr
import pt.isel.tictactoe.DependenciesProvider
import pt.isel.tictactoe.element.Button
import pt.isel.tictactoe.element.Center
import pt.isel.tictactoe.element.SideBar
import pt.isel.tictactoe.service.local.Page as LeaderboardPage

@Import("stylesheet", "text/css", "/css/leaderboard.css")
@Page("/leaderboard")
fun Tag.Leaderboard() = apply {
    SideBar()
    Center {
        Script(Attribute.src("/js/leaderboard.js"))

        val pageSize = 10
        val loadLeaderboard: EventHandler = {
            console.log("loading leaderboard...")
            val page = Var(LeaderboardPage(0, pageSize))
            val scoreService = (scope.application as DependenciesProvider).scoreServiceProvider.scoreService
            val leaderboard = scoreService.getLeaderboard(this@Center, this, page)
            console.log(leaderboard)
            call("populateLeaderboard", leaderboard)
        }

        Div(
            Attribute.`class`("leaderboard")
        ) {
            Table {
                Thead {
                    Tr {
                        Th { Text { "Place" } }
                        Th { Text { "Username" } }
                        Th { Text { "Wins" } }
                    }
                }

                Tbody { }
            }
        }
        Div {
            Button("Back", "secondary-color-4") { call("navigate", "/") }
        }
        Script {
            call(loadLeaderboard)
        }
    }
    SideBar()
}
