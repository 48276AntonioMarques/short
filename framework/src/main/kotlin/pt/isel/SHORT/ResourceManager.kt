package pt.isel.SHORT

import java.net.URL

fun getResource(name: String): URL? {
    val resource = object {}.javaClass.getResource(name)
    if (resource != null) {
        return resource
    }
    // Not found
    // Log on the server
    println("Resource not found: $name")
    return null
}
