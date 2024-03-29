package pt.isel.SHORT.html.element

import pt.isel.SHORT.ResourceNotFoundException
import pt.isel.SHORT.getResource
import pt.isel.SHORT.html.HtmlTag

fun HtmlTag.Script(code: () -> String) = apply {
    appendChild(
        prototype("script") {
            Text(code)
        }
    )
}

fun HtmlTag.Script(resource: String) = apply {
    Script {
        try {
            getResource(name = resource).readText()
        }
        catch (rnfe: ResourceNotFoundException) {
            "console.log('Resource not found: $resource')"
        }
    }
}
