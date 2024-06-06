package pt.isel.short.generator

import pt.isel.short.generator.element.ELEMENTS_OUTPUT
import pt.isel.short.generator.element.ELEMENTS_SOURCE
import pt.isel.short.generator.element.generateElements
import pt.isel.short.generator.element.getElements
import java.io.File

class GenerateElementRun : Generator {
    override fun generate() {
        val blacklist = listOf("html", "head", "body")
        val elements = getElements(ELEMENTS_SOURCE, blacklist)
        val files = generateElements(elements)

        val dir = File("./")
        println(dir.absolutePath)
        var count = 0
        try {
            files.forEach { file ->
                print("Generating: ${file.first}...")
                File("$ELEMENTS_OUTPUT/${file.first}.kt").writeText(file.second)
                println("\rGenerated: ${file.first}.")
                count++
            }
        } catch (e: Exception) {
            println()
            throw e
        } finally {
            println("Generated: $count files.   ")
        }
    }
}
