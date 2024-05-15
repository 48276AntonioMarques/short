import pt.isel.short.generator.ATTRIBUTES_OUTPUT
import pt.isel.short.generator.ATTRIBUTES_SOURCE
import pt.isel.short.generator.ELEMENTS_SOURCE
import pt.isel.short.generator.generateElements
import pt.isel.short.generator.getAttributes
import pt.isel.short.generator.getElements
import java.io.File
import kotlin.test.Test

class GenerateAttributeRun {
    @Test
    fun generateAttributes() {
        val blacklist = listOf("class")
        val attributes = getAttributes(ATTRIBUTES_SOURCE, blacklist)
        val files = pt.isel.short.generator.generateAttributes(attributes)

        var count = 0
        try {
            files.forEach { file ->
                print("Generating: ${file.first}...")
                File("$ATTRIBUTES_OUTPUT/${file.first.replace("*", "any")}.kt").writeText(file.second)
                println("\rGenerated: ${file.first}.")
                count++
            }
        } finally {
            println("Generated: $count files.")
        }
    }
}
