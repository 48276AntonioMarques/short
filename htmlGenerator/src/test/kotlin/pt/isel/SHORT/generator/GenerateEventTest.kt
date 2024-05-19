package pt.isel.SHORT.generator

import pt.isel.short.generator.event.EVENTS_SOURCE
import pt.isel.short.generator.event.generateEvents
import pt.isel.short.generator.event.getEvents
import kotlin.test.Test

class GenerateEventTest {
    @Test
    fun generateEvents() {
        val blacklist = emptyList<String>()
        val attributes = getEvents(EVENTS_SOURCE, blacklist)
        val files = generateEvents(attributes)

        println("Events: ${files.size}")
        files.forEach { file ->
            println(file.first)
            println("#".repeat(20))
            println(file.second)
        }
    }
}
