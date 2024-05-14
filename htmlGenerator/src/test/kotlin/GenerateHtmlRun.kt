import pt.isel.short.generator.ELEMENTS_OUTPUT
import pt.isel.short.generator.ELEMENTS_SOURCE
import pt.isel.short.generator.generateElements
import pt.isel.short.generator.getElements
import java.io.File
import kotlin.test.Test

class GenerateHtmlRun {
    @Test
    fun generateHtml() {
        val blacklist = listOf("html", "head", "body", "base", "meta", "title", "noscript", "template")
        val elements = getElements(ELEMENTS_SOURCE, blacklist)
        val files = generateElements(elements)

        files.forEach { file ->
            File("$ELEMENTS_OUTPUT/${file.first}.kt").writeText(file.second)
        }
    }
}
