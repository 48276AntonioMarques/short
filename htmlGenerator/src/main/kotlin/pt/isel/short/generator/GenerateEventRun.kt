package pt.isel.short.generator

import pt.isel.short.generator.event.EVENTS_OUTPUT
import pt.isel.short.generator.event.EVENTS_SOURCE
import pt.isel.short.generator.event.generateEvents
import pt.isel.short.generator.event.getEvents
import java.io.File

class GenerateEventRun: Generator {
    override fun generate() {
        val blacklist = emptyList<String>()
        val events = getEvents(EVENTS_SOURCE, blacklist)
        val files = generateEvents(events)

        var count = 0
        try {
            files.forEach { file ->
                print("Generating: ${file.first}...")
                File("$EVENTS_OUTPUT/${file.first}.kt").writeText(file.second)
                println("\rGenerated: ${file.first}.")
                count++
            }
        } finally {
            println("Generated: $count files.")
        }
    }
}
