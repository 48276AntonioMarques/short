package pt.isel.tictactoe.page

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.P
import pt.isel.tictactoe.element.Button
import pt.isel.tictactoe.element.Center
import pt.isel.tictactoe.element.SideBar
import pt.isel.tictactoe.element.Title

@Page("/about")
fun Tag.about() = apply {
    SideBar()
    Center {
        Title("About")
        P {
            Text {
                """
                This is a simple Tic Tac Toe game developed by a student from the Instituto Superior de Engenharia de Lisboa. <br>
                It is part of the course named "Projeto e Seminário" from "Licenciatura em Engenharia Informática e de Computadores". <br>
                The main goal of this web application is to provide an tangible example of a web application developed using the SHORT framework.
                """.trimIndent()
            }
        }
        Div {
            Text {
                "Developed by: António Marques"
            }
        }
        Div {
            Text {
                "Version: 0.1-beta"
            }
        }
        Div {
            Button("Back", "secondary-color-1") { call("navigate", "/") }
        }
    }
    SideBar()
}
