package pt.isel.SHORT.client.`object`

import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.client.JsObject

class Target(private val _value: String, private val script: JavaScript) : JsObject {
    override fun toJs(): String = _value

    val value = script.registerProperty(Any(), "${toJs()}.value;")
}
