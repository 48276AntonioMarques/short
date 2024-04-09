import pt.isel.short.generator.ELEMENTS_SOURCE
import pt.isel.short.generator.generateElements
import pt.isel.short.generator.getElements
import kotlin.test.Test

class GenerateHtmlTest {
    @Test
    fun generateHtml() {
        val blacklist = listOf("html", "head", "body", "base", "link", "meta", "title", "noscript", "template")
        val elements = getElements(ELEMENTS_SOURCE, blacklist)
        val files = generateElements(elements)

        files.forEach { file ->
            println(file.first)
            println("#".repeat(20))
            println(file.second)
        }
    }
}
