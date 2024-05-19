package pt.isel.SHORT

import org.http4k.routing.ResourceLoader
import java.net.URL

class SpaLoader : ResourceLoader {
    override fun load(path: String): URL? {
        // In here there's no access to Request or Response
        val url = when {
            // FIXME: Don't make this hardcoded/URL dependent
            path.startsWith("public") -> "http://localhost:9000/${path.drop(6)}"
            path.startsWith("/public") -> "http://localhost:9000/${path.drop(7)}"
            else -> "http://localhost:9000/"
        }
        return URL(url)
    }
}
