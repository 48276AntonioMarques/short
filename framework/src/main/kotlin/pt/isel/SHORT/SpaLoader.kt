package pt.isel.SHORT

import org.http4k.routing.ResourceLoader
import java.net.URL

class SpaLoader : ResourceLoader {
    override fun load(path: String): URL? {
        // In here there's no access to Request or Response
        return URL("http://localhost:9000/")
    }
}
