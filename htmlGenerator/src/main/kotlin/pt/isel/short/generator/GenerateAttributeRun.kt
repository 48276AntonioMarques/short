package pt.isel.short.generator

import pt.isel.short.generator.attribute.ATTRIBUTES_OUTPUT
import pt.isel.short.generator.attribute.ATTRIBUTES_SOURCE
import pt.isel.short.generator.attribute.generateAttributes
import pt.isel.short.generator.attribute.getAttributes
import java.io.File

class GenerateAttributeRun: Generator {
    override fun generate() {
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
