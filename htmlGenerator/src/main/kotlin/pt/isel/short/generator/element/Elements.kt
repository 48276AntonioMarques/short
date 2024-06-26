package pt.isel.short.generator.element

import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request
import pt.isel.short.generator.attribute.formatText
import pt.isel.short.generator.clearScripts
import pt.isel.short.generator.getTables
import pt.isel.short.generator.getTags

const val ELEMENTS_SOURCE = "https://developer.mozilla.org/en-US/docs/Web/HTML/Element"
const val ELEMENTS_OUTPUT = "./framework/src/main/kotlin/pt/isel/SHORT/html/element/"
const val VOID_ELEMENTS = "area, base, br, col, embed, hr, img, input, link, meta, source, track, wbr"

fun getElements(source: String, blacklist: List<String>): List<Pair<String, String>> {
    val client = ApacheClient()
    val request = Request(Method.GET, source)
    val response = client(request)
    val bodyString = response.bodyString()
    val safeBodyString = clearScripts(bodyString)

    val tables: List<String> = getTables(safeBodyString)
    val elements: List<Pair<String, String>> = getElementsFromTables(tables)
    val allowedElements: List<Pair<String, String>> = elements.filter { (tag, _) -> !blacklist.contains(tag) }
    return allowedElements
}

fun getElementsFromTables(tables: List<String>): List<Pair<String, String>> {
    return tables.flatMap { table ->
        val tableHead = getTags("thead", table)
        if (tableHead.size != 1) return@flatMap emptyList()
        val headRow = getTags("tr", tableHead[0])
        if (headRow.size != 1) return@flatMap emptyList()
        val head = getTags("th", headRow[0])
        if (head.size != 2 || head[0] == "Element" || head[1] == "Description") return@flatMap emptyList()

        val tableBody = getTags("tbody", table)
        if (tableBody.size != 1) return@flatMap emptyList()

        val rows = getTags("tr", tableBody[0])

        rows.flatMap { row ->
            val columns = getTags("td", row)
            if (columns.size != 2) {
                emptyList()
            } else {
                val links = getTags("a", columns[0])
                links.mapNotNull { link ->
                    val code = getTags("code", link)
                    if (code.size != 1) return@mapNotNull null
                    val codeContent = code[0]
                        .replace(Regex("<[^>]*>"), "")
                        .replace(Regex("&[^;]*;"), "")
                    val descriptionContent = columns[1]
                        .replace(Regex("<[^>]*>"), "")
                        .replace(Regex("&[^;]*;"), "")
                    Pair(codeContent, descriptionContent)
                }
            }
        }
    }
}

fun generateElements(elements: List<Pair<String, String>>): List<Pair<String, String>> {
    val voidElements = VOID_ELEMENTS.split(", ")
    return elements.map { (element, description) ->
        val capitalizedElement = element.replaceFirstChar { c -> c.uppercaseChar() }
        val importElement = if (voidElements.contains(element)) {
            "import pt.isel.SHORT.html.base.element.VoidTag"
        } else {
            "import pt.isel.SHORT.html.base.element.prototype"
        }
        val newElement = if (voidElements.contains(element)) {
            "VoidTag(\"$element\", attributes, scope)"
        } else {
            "prototype(\"$element\", attributes, scope, content)"
        }
        Pair(
            capitalizedElement,
            """
                package pt.isel.SHORT.html.element
                
                import pt.isel.SHORT.html.base.attribute.Attribute
                import pt.isel.SHORT.html.base.element.HtmlReceiver
                import pt.isel.SHORT.html.base.element.Tag
                $importElement
                
                /**
                 * Represents the HTML <$element> tag.
                 * Description: ${formatText(description)}
                 */
                fun Tag.$capitalizedElement(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
                    appendChild($newElement)
                }
    
            """.trimIndent()
        )
    }
}
