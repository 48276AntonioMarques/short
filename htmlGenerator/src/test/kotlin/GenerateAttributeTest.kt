import pt.isel.short.generator.ATTRIBUTES_SOURCE
import pt.isel.short.generator.generateAttributes
import pt.isel.short.generator.getAttributes
import kotlin.test.Test

class GenerateAttributeTest {
    @Test
    fun generateAttributes() {
        val blacklist = emptyList<String>()
        val attributes = getAttributes(ATTRIBUTES_SOURCE, blacklist)
        val files = generateAttributes(attributes)

        println("Attributes: ${files.size}")
        files.forEach { file ->
            println(file.first)
            println("#".repeat(20))
            println(file.second)
        }
    }
}
