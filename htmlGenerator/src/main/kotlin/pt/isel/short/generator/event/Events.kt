package pt.isel.short.generator.event

import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request
import pt.isel.short.generator.clearScripts
import pt.isel.short.generator.getTables
import pt.isel.short.generator.getTags

const val EVENTS_SOURCE = "https://www.w3schools.com/tags/ref_eventattributes.asp"
const val EVENTS_OUTPUT = "./framework/src/main/kotlin/pt/isel/SHORT/html/event/"

fun getEvents(source: String, blacklist: List<String>): List<Event> {
    val client = ApacheClient()
    val request = Request(Method.GET, source)
    val response = client(request)
    val bodyString = response.bodyString()
    val safeBodyString = clearScripts(bodyString)

    val tables: List<String> = getTables(safeBodyString)
    val events: List<Event> = getEventsFromTables(tables)
    val allowedEvents: List<Event> = events.filter { (name, _) -> !blacklist.contains(name) }
    return allowedEvents
}

fun getEventsFromTables(tables: List<String>): List<Event> {
    return tables.flatMap { table ->
        val tableContent = getTags("tr", table)
        if (tableContent.size < 2) return@flatMap emptyList()
        val headRow = tableContent[0]
        val head = getTags("th", headRow)
        if (head.size != 3 || head[0] == "Attribute" || head[1] == "Value" || head[2] == "Description") return@flatMap emptyList()

        val rows = tableContent.drop(1)
        rows.flatMap { row ->
            val columns = getTags("td", row)
            if (columns.size != 3) {
                emptyList()
            } else {
                val name = columns[0]
                    .replace(Regex("<[^>]*>"), "")
                    .replace(Regex("&[^;]*;"), "")
                val value = columns[1]
                    .replace(Regex("<[^>]*>"), "")
                    .replace(Regex("&[^;]*;"), "")

                val descriptionContent = columns[2]
                    .replace(Regex("<[^>]*>"), "")
                    .replace(Regex("&[^;]*;"), "")
                listOf(Event(name, value, descriptionContent))
            }
        }
    }
}

fun generateEvents(events: List<Event>): List<Pair<String, String>> {
    return events.map { event -> event.generateFile() }
}
