package pt.isel.short.generator.event

import pt.isel.short.generator.attribute.formatName
import pt.isel.short.generator.attribute.formatText
import pt.isel.short.generator.attribute.wrapReservedWords

data class Event(val name: String, val value: String, val description: String) {
    fun generateFile(): Pair<String, String> {
        val formatedName = formatName(name)
        val functionName = wrapReservedWords(formatedName)
        val state = if (description.contains("Deprecated")) {
            "@Deprecated(\"This event is deprecated.\")\n                "
        } else {
            ""
        }
        val documentation =
            """
                /**
                 * Represents the HTML $name event.
                 * Description: ${formatText(description)}.
                 * @param value $value
                 */"""
        return Pair(
            formatedName.replaceFirstChar { c -> c.uppercaseChar() },
            """
                package pt.isel.SHORT.html.event

                import pt.isel.SHORT.client.EventHandler
                import pt.isel.SHORT.html.base.attribute.Attribute
                import pt.isel.SHORT.html.base.attribute.add
                $documentation
                ${state}fun Attribute.Companion.$functionName(value: EventHandler) = add("$name", value)
                $documentation
                ${state}fun List<Attribute>.$functionName(value: EventHandler) = add("$name", value)

            """.trimIndent()
        )
    }
}
