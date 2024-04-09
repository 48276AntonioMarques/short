package pt.isel.short.generator

import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request

const val ELEMENTS_SOURCE = "https://developer.mozilla.org/en-US/docs/Web/HTML/Element"
const val ELEMENTS_OUTPUT = "./../framework/src/main/kotlin/pt/isel/SHORT/html/element/"

fun getElements(source: String, blacklist: List<String>): List<Pair<String, String>> {
    val client = ApacheClient()
    val request = Request(Method.GET, ELEMENTS_SOURCE)
    val response = client(request)
    val bodyString = response.bodyString()

    val tables: List<String> = getTables(bodyString)
    val elements: List<Pair<String, String>> = getTableRows(tables)
    val allowedElements: List<Pair<String, String>> = elements.filter { (tag, _) -> !blacklist.contains(tag) }
    // elements.forEach { (tag, description) -> println("$tag -> $description") }
    return allowedElements
}

fun generateElements(elements: List<Pair<String, String>>): List<Pair<String, String>> {
    // TODO: Format description
    return elements.map { (element, description) ->
        val capitalizedElement = element.replaceFirstChar { c -> c.uppercaseChar() }
        Pair(capitalizedElement,
            """
               package pt.isel.SHORT.html.element
    
               import pt.isel.SHORT.html.Attribute
               import pt.isel.SHORT.html.Tag
    
                /**
                * Represents the HTML <$element> tag.
                * Description: $description
                */
               fun Tag.$capitalizedElement(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
                   appendChild(prototype("$element", attributes, content))
               }
    
            """.trimIndent()
        )
    }
}
