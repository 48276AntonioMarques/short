package pt.isel.tictactoe

import pt.isel.SHORT.html.attribute.id
import pt.isel.SHORT.html.attribute.src
import pt.isel.SHORT.html.base.Script
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Img
import pt.isel.SHORT.html.element.Style

fun Tag.loadingScreen() =
    Div(
        attributes = Attribute.id("loading-screen")
    ) {
        Style {
            Text {
                """
                body {
                    background-color: #1C2C3A;
                    overflow: hidden;
                }
                #loading-screen {
                    position: fixed;
                    z-index: 1000;
                    top: 45%;
                    left: 45%;
                    width: 10%;
                    height: 10%;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                }
                img {
                    width: 20vh;
                    height: 20vh;
                }
                @media (orientation: portrait) {
                  img {
                    width: 20vw;
                    height: 20vw    ;
                  }
                }
                """.trimIndent()
            }
        }
        Img(attributes = Attribute.src("images/loading.gif"))
        Script(Attribute.src("js/loadingScreen.js"))
    }
