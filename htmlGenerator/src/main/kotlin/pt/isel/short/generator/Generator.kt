package pt.isel.short.generator

interface Generator {
    fun generate()
}

fun main() {
    val generator = GenerateAttributeRun()
    // val generator = GenerateElementRun()
    // val generator = GenerateEventRun()
    generator.generate()
}
