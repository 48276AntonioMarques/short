package pt.isel.tictactoe.page

import pt.isel.SHORT.Page
import pt.isel.SHORT.client.Var
import pt.isel.SHORT.html.attribute.`class`
import pt.isel.SHORT.html.base.Script
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.css.Import
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Table
import pt.isel.SHORT.html.element.Tbody
import pt.isel.SHORT.html.element.Td
import pt.isel.SHORT.html.element.Th
import pt.isel.SHORT.html.element.Thead
import pt.isel.SHORT.html.element.Tr
import pt.isel.tictactoe.DependenciesProvider
import pt.isel.tictactoe.element.Button
import pt.isel.tictactoe.element.Center
import pt.isel.tictactoe.element.SideBar
import pt.isel.tictactoe.service.remote.Leaderboard
import pt.isel.tictactoe.service.remote.ScoreEntry

@Import("stylesheet", "text/css", "/css/leaderboard.css")
@Page("/leaderboard")
fun Tag.Leaderboard() = apply {
    SideBar()
    Center {
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

                val page = Var(pt.isel.tictactoe.service.local.Page(0, 10))
                val scoreService = (scope.application as DependenciesProvider).scoreServiceProvider.scoreService
                val table = scoreService.getLeaderboard(this@Table, page)

                Script {
                    console.log(table)
                }

                Tbody {
                    for (i in 1..10) {
                        Tr {
                            val name = table.field<Leaderboard, List<ScoreEntry>>("scores")
                            Td { Text { "$i" } }
                            Td { Text { "______" } }
                            Td { Text { "0" } }
                        }
                    }
                    /*
                    table.forEachIndexed { (place, username, wins) ->
                        Tr {
                            Td { Text { place } }
                            Td { Text { username } }
                            Td { Text { wins } }
                        }
                    }
                    */
                }
            }
        }
        Div {
            Button("Back", "secondary-color-4") { call("navigate", "/") }
        }
    }
    SideBar()
}
