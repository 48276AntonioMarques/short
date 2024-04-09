package pt.isel.SHORT.html.element

import pt.isel.SHORT.JavaScriptException
import pt.isel.SHORT.ResourceNotFoundException
import pt.isel.SHORT.getResource
import pt.isel.SHORT.html.Tag

/**
 * Generates a script element in the Page HTML.
 * @param code the code to be executed
 * The code will be created when the corresponding page is created.
 */
fun Tag.Script(code: () -> String) = apply {
    appendChild(
        prototype("script") {
            Text(code)
        }
    )
}

/**
 * Imports a script from a resource into the Page HTML.
 * @param resource the path to the resource
 * @throws JavaScriptException if the resource is not found
 * The resource will be imported when this function is invoked.
 */
fun Tag.Script(resource: String) = apply {
    try {
        val content = getResource(name = resource).readText()
        appendChild(
            prototype("script") {
                Text {
                    content
                }
            }
        )
    } catch (_: ResourceNotFoundException) {
        // "console.log('Resource not found: $resource')"
        throw JavaScriptException("Resource not found: $resource")
    }
}
