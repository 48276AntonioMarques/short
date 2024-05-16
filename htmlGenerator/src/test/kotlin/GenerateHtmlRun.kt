import pt.isel.short.generator.ELEMENTS_OUTPUT
import pt.isel.short.generator.ELEMENTS_SOURCE
import pt.isel.short.generator.generateElements
import pt.isel.short.generator.getElements
import java.io.File
import kotlin.test.Test

class GenerateHtmlRun {
    @Test
    fun generateHtml() {
        val blacklist = listOf("html", "head", "body")
        val elements = getElements(ELEMENTS_SOURCE, blacklist)
        val files = generateElements(elements)

        var count = 0
        try {
            files.forEach { file ->
                print("Generating: ${file.first}...")
                File("$ELEMENTS_OUTPUT/${file.first}.kt").writeText(file.second)
                println("\rGenerated: ${file.first}.")
                count++
            }
        } finally {
            println("Generated: $count files.")
        }
    }
}
