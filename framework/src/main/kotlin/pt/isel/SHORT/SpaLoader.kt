package pt.isel.SHORT

import io.github.oshai.kotlinlogging.KotlinLogging
import org.http4k.routing.ResourceLoader
import java.net.URL


class SpaLoader(private val port: Int) : ResourceLoader {

    override fun load(path: String): URL {
        return URL("http", "localhost", port, "/")
    }
}
