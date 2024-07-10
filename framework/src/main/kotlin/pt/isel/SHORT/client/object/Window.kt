package pt.isel.SHORT.client.`object`

import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.client.JsObject

class Window(script: JavaScript) : JsObject {
    override fun toJs(): String = "window"

    val localStorage = Storage("${toJs()}.localStorage", script)
    val sessionStorage = Storage("${toJs()}.sessionStorage", script)
}
