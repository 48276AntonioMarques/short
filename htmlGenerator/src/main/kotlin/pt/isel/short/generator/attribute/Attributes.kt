package pt.isel.short.generator.attribute

import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request
import pt.isel.short.generator.clearScripts
import pt.isel.short.generator.getTables
import pt.isel.short.generator.getTags

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
    return attributes.map { (name, elements, description) ->
        val formatedName = formatName(name)
        val functionName = wrapReservedWords(formatedName)
        val documentation =
            """
                /**
                 * Represents the HTML $name attribute.
                 * Description: ${formatText(description)}.
                 * Supported elements: ${formatText(elements.map { "<$it>" }.joinToString(", "))}
                 */"""
        Pair(
            formatedName.replaceFirstChar { c -> c.uppercaseChar() },
            """
                package pt.isel.SHORT.html.attribute
                
                import pt.isel.SHORT.html.base.attribute.Attribute
                import pt.isel.SHORT.html.base.attribute.add
                $documentation
                fun Attribute.Companion.$functionName(value: String) = add("$name", value)
                $documentation
                fun List<Attribute>.$functionName(value: String) = add("$name", value)
                
            """.trimIndent()
        )
    }
}

fun formatName(name: String): String {
    return name
        .replace("*", "any")
        .replace(Regex("-[A-z]")) { match ->
            match
                .value
                .replace("-", "")
                .replaceFirstChar { c -> c.uppercaseChar() }
        }
}

fun formatText(text: String): String {
    var output = text
        .replace("\n", " ")
        .replace("\t", " ")
        .trim()
    while (output.contains("  ")) {
        output = output.replace("  ", " ")
    }
    return output
}

fun wrapReservedWords(name: String): String {
    val reservedWords = listOf(
        "as",
        "is",
        "as?",
        "break",
        "class",
        "continue",
        "do",
        "else",
        "false",
        "for",
        "fun",
        "if",
        "in",
        "is",
        "!in",
        "!is",
        "null",
        "object",
        "package",
        "return",
        "super",
        "this",
        "throw",
        "true",
        "try",
        "typealias",
        "typeof",
        "val",
        "var",
        "when",
        "while",
        "by",
        "catch",
        "constructor",
        "delegate",
        "dynamic",
        "field",
        "file",
        "finally",
        "get",
        "import",
        "init",
        "param",
        "property",
        "receiveris",
        "set",
        "setparam",
        "value",
        "where",
        "abstract",
        "actual",
        "annotation",
        "companion",
        "const",
        "crossinline",
        "data",
        "enum",
        "expect",
        "external",
        "final",
        "infix",
        "inline",
        "inner",
        "internal",
        "lateinit",
        "noinline",
        "open",
        "operator",
        "out",
        "override",
        "private",
        "protected",
        "public",
        "reified",
        "sealed",
        "suspend",
        "tailrec",
        "vararg",
        "field",
        "it"
    )
    return if (reservedWords.contains(name)) "`$name`" else name
}
