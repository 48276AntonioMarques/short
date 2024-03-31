package pt.isel.SHORT.html.element

import pt.isel.SHORT.JavaScriptException
import pt.isel.SHORT.ResourceNotFoundException
import pt.isel.SHORT.getResource
import pt.isel.SHORT.html.Tag

fun Tag.Script(code: () -> String) = apply {
    appendChild(
        prototype("script") {
            Text(code)
        }
    )
}

fun Tag.Script(resource: String) = apply {
    Script {
        try {
            getResource(name = resource).readText()
        } catch (_: ResourceNotFoundException) {
            // "console.log('Resource not found: $resource')"
            throw JavaScriptException("Resource not found: $resource")
        }
    }
}
