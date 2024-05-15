package pt.isel.short.generator

import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request

const val ATTRIBUTES_SOURCE = "https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes"
const val ATTRIBUTES_OUTPUT = "./../framework/src/main/kotlin/pt/isel/SHORT/html/attribute/"

fun getAttributes(source: String, blacklist: List<String>): List<Attribute> {
    val client = ApacheClient()
    val request = Request(Method.GET, source)
    val response = client(request)
    val bodyString = response.bodyString()
    val safeBodyString = clearScripts(bodyString)

    val tables: List<String> = getTables(safeBodyString)
    val attributes: List<Attribute> = getAttributesFromTables(tables)
    val allowedAttributes: List<Attribute> = attributes.filter { (name, _) -> !blacklist.contains(name) }
    return allowedAttributes
}

fun getAttributesFromTables(tables: List<String>): List<Attribute> {
    return tables.flatMap { table ->
        val tableHead = getTags("thead", table)
        if (tableHead.size != 1) return@flatMap emptyList()
        val headRow = getTags("tr", tableHead[0])
        if (headRow.size != 1) return@flatMap emptyList()
        val head = getTags("th", headRow[0])
        if (head.size != 3 || head[0] == "Attribute Name" || head[1] == "Elements" || head[2] == "Description") return@flatMap emptyList()

        val tableBody = getTags("tbody", table)
        if (tableBody.size != 1) return@flatMap emptyList()

        val rows = getTags("tr", tableBody[0])
        rows.flatMap { row ->
            val columns = getTags("td", row)
            if (columns.size != 3) {
                emptyList()
            } else {
                val codes = getTags("code", columns[0])
                codes.mapNotNull { code ->
                    val link = getTags("a", code)
                    val linkContent = if (link.isEmpty()) {
                        if (code.contains(Regex(""))) code else ""
                    } else {
                        link[0]
                    }
                    if (linkContent.isBlank()) return@mapNotNull null
                    val name = linkContent
                        .replace(Regex("<[^>]*>"), "")
                        .replace(Regex("&[^;]*;"), "")

                    val elements = columns[1]
                        .replace(Regex("<[^>]*>"), "")
                        .replace(Regex("&[^;]*;"), "")
                        .split(", ")

                    val descriptionContent = columns[2]
                        .replace(Regex("<[^>]*>"), "")
                        .replace(Regex("&[^;]*;"), "")
                    Attribute(name, elements, descriptionContent)
                }
            }
        }
    }
}

fun generateAttributes(attributes: List<Attribute>): List<Pair<String, String>> {
    // TODO: Format description
    return attributes.map { (name, elements, description) ->
        val capitalizedAttribute = name.replaceFirstChar { c -> c.uppercaseChar() }
        Pair(
            capitalizedAttribute,
            """
                package pt.isel.SHORT.html.attribute
                
                import pt.isel.SHORT.html.Attribute
                import pt.isel.SHORT.html.add

                /**
                 * Represents the HTML $name attribute.
                 * Description: ${formatText(description)}
                 * Supported elements: ${formatText(elements.map { "<$it>" }.joinToString(", "))}
                 */
                fun Attribute.Companion.$name(value: String) = add("$name", value)
                fun List<Attribute>.$name(value: String) = add("$name", value)
            """.trimIndent()
        )
    }
}

fun formatText(text: String): String {
    var output = text
        .replace("\n", " ")
        .replace("\t", "")
    while (output.contains("  ")) {
        output = output.replace("  ", " ")
    }
    return output
}
