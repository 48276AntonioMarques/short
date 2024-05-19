package pt.isel.SHORT.client

typealias JsHandler = JavaScript.() -> Unit

open class JavaScript {
    private val script = StringBuilder()

    val console = Console(script)

    fun toHtml(): String {
        script.insert(0, "/*Client Script*/")
        println(script.toString())
        return script.toString()
    }
}
