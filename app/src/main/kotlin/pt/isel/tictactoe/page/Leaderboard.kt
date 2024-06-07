package pt.isel.tictactoe.page

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.attribute.`class`
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
import pt.isel.tictactoe.element.Button
import pt.isel.tictactoe.element.Center
import pt.isel.tictactoe.element.SideBar


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

                val table = listOf(
                        Triple("1", "António Marques", "10"),
                        Triple("2", "Rui Pedrosa", "9"),
                        Triple("3", "Felipe Brito", "7")
                )
                Tbody {
                    table.forEach { (place, username, wins) ->
                        Tr {
                            Td { Text { place } }
                            Td { Text { username } }
                            Td { Text { wins } }
                        }
                    }
                }
            }
        }
        Div {
            Button("Back", "secondary-color-4") { call("navigate", "/") }
        }
    }
    SideBar()
}
