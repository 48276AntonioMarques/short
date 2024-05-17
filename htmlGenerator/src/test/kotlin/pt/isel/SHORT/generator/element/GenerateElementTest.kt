package pt.isel.SHORT.generator.element

import pt.isel.short.generator.element.ELEMENTS_SOURCE
import pt.isel.short.generator.element.generateElements
import pt.isel.short.generator.element.getElements
import kotlin.test.Test

class GenerateElementTest {
    @Test
    fun generateHtml() {
        val blacklist = listOf("html", "head", "body")
        val elements = getElements(ELEMENTS_SOURCE, blacklist)
        val files = generateElements(elements)

        println("Elements: ${elements.size}")
        files.forEach { file ->
            println(file.first)
            println("#".repeat(20))
            println(file.second)
        }
    }
}
