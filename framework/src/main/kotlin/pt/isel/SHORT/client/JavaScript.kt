package pt.isel.SHORT.client

typealias JsHandler = JavaScript.() -> Unit

open class JavaScript {
    private val script = StringBuilder()

    val console = Console(script)

    fun call(function: String, vararg args: String) {
        val argString = if (args.isNotEmpty()) "\"${args.joinToString("\", |")}\"" else ""
        script.append("$function($argString);")
    }

    fun toHtml(): String {
        return script.toString()
    }
}
