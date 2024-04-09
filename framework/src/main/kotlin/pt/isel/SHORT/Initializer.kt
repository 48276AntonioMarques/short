package pt.isel.SHORT

import io.github.oshai.kotlinlogging.KotlinLogging
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.then
import org.http4k.filter.CachingFilters
import org.http4k.routing.ResourceLoader.Companion.Classpath
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.routing.singlePageApp
import org.http4k.routing.static
import org.http4k.server.Http4kServer
import org.http4k.server.asServer
import pt.isel.SHORT.config.templateUserAgentRequirements
import pt.isel.SHORT.html.Html
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.element.Body
import pt.isel.SHORT.request.UserAgent

private val logger = KotlinLogging.logger {}

typealias WebApp = Html

/**
 * Top level function acting as a Kotlin shortcut allowing to write
 * `runApplication<FooApplication>(args)` instead of
 * `runApplication(FooApplication::class.java, args)`.
 */

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Application> runSHORT(args: Array<String>) {
    // This cast should always succeed since T is a subclass of Application
    runSHORT(T::class.java as Class<Application>, args)
}

/**
 * Starts a SHORT application using the given [sourceManagerClass] and [args].
 * The [sourceManagerClass] must be a subclass of [Application].
 * Create a new instance of [sourceManagerClass]. The context will be loaded from the overridden methods
 * The instance can have more function that will be used to inject dependencies in the pages
 * @return the server that is running the application.
 */
fun runSHORT(sourceManagerClass: Class<Application>, args: Array<String>): Http4kServer {
    // Instantiate the sources manager
    logger.debug { "Initializing sources manager..." }
    val sourceManager: Application

    try {
        sourceManager = sourceManagerClass.getDeclaredConstructor(emptyArray<String>().javaClass).newInstance(args)
    } catch (e: Exception) {
        throw RuntimeException("Couldn't create an instance of the source manager", e)
    }

    // Declare public content
    // TODO: Verify this does allow hack it to access all files in /resources
    val public = routes(
        "/" bind CachingFilters.Response.NoCache()
            .then(static(Classpath("public/")))
    )

    // Generate the loading page
    logger.debug { "Generating loading page..." }
    var loadingScreen: Tag? = null
    val root = Html {
        Body {
            loadingScreen = sourceManager.getLoadingScreen(this)
        }
    }
    val loadingPage = if (loadingScreen == null) {
        { _: Request -> Response(Status(102, "Processing")).body("Server is starting.") }
    } else {
        { _: Request -> Response(Status.OK).body(root.toHtml()) }
    }

    // Register loading page
    logger.debug { "Registering loading page..." }
    val loadingPath = routes(public, "/" bind Method.GET to loadingPage)

    // Launch temporary server
    logger.debug { "Starting temporary server..." }
    val tempServer = loadingPath.asServer(sourceManager.getServerConfig()).start()
    logger.info { "Temporary server started at port ${tempServer.port()}." }

    // TODO: Add a way to artificially delay the server start in here (for debugging purposes)
    // Thread.sleep(10000)

    // Generate the web app
    logger.debug { "Generating web app..." }
    val webApp = generateWebApp()

    // Register new routes
    logger.debug { "Registering exposed paths..." }
    val exposedPaths = routes(
        public,
        "/" bind Method.GET to { request: Request ->
            val aggregationMode = try {
                // Check if the request as a header that forces the legacy mode
                when (request.query("Aggregation")) {
                    "LEGACY" -> throw TemplateAggregationException("Legacy mode forced")
                }

                // Check if the browser is compatible with template aggregation mode
                val userAgent = request.header("User-Agent")
                val requirements = templateUserAgentRequirements
                if (requirements.verifyUserAgentCompatibility(userAgent, UserAgent.Criteria.LESS_THAN)) {
                    throw TemplateAggregationException("User agent not supported")
                }
                AggregationMode.TEMPLATE
            } catch (e: TemplateAggregationException) {
                AggregationMode.LEGACY
            }
            Response(Status.OK).body(webApp.using(aggregationMode).toHtml())
        },
        singlePageApp(SpaLoader())
    )

    // Stop the temporary server
    logger.debug { "Stopping temporary server..." }
    tempServer.stop()

    // Launch definitive server
    logger.debug { "Starting definitive server..." }
    val server = exposedPaths.asServer(sourceManager.getServerConfig()).start()
    logger.info { "Server started at port ${server.port()}." }

    return server
}
