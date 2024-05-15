import pt.isel.short.generator.ATTRIBUTES_OUTPUT
import pt.isel.short.generator.ATTRIBUTES_SOURCE
import pt.isel.short.generator.generateAttributes
import pt.isel.short.generator.getAttributes
import java.io.File
import kotlin.test.Test

class GenerateAttributeRun {
    @Test
    fun generateAttributes() {
        val blacklist = emptyList<String>()
        val attributes = getAttributes(ATTRIBUTES_SOURCE, blacklist)
        val files = generateAttributes(attributes)

        var count = 0
        try {
            files.forEach { file ->
                print("Generating: ${file.first}...")
                File("$ATTRIBUTES_OUTPUT/${file.first}.kt").writeText(file.second)
                println("\rGenerated: ${file.first}.")
                count++
            }
        } finally {
            println("Generated: $count files.")
        }
    }
}
