package pt.isel.SHORT

import io.github.oshai.kotlinlogging.KotlinLogging
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.bind
import org.http4k.routing.routes
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

    // Register loading page
    logger.debug { "Registering loading page..." }
    val loadingPath = routes(
        "/" bind Method.GET to { _: Request ->
            var loadingScreen: Tag? = null
            val root = Html {
                Body {
                    loadingScreen = sourceManager.getLoadingScreen(this)
                }
            }
            if (loadingScreen == null) {
                Response(Status(102, "Processing")).body("Server is starting.")
            } else {
                Response(Status.OK).body(root.toHtml())
            }
        }
    )

    // Launch temporary server
    logger.debug { "Starting temporary server..." }
    val tempServer = loadingPath.asServer(sourceManager.getServerConfig()).start()
    logger.info { "Temporary server started at port ${tempServer.port()}." }

    // Generate the web app
    logger.debug { "Generating web app..." }
    val webApp = generateWebApp()

    // Register new routes
    logger.debug { "Registering exposed paths..." }
    val exposedPaths = routes(
        "/" bind Method.GET to { request: Request ->
            val userAgent = request.header("User-Agent")
            // Verifying aggregation mode
            val requirements = templateUserAgentRequirements
            if (requirements.verifyUserAgentCompatibility(userAgent, UserAgent.Criteria.GREATER_THAN_OR_EQUAL)) {
                webApp.enableLegacyAggregation()
            }
            Response(Status.OK).body(webApp.toHtml())
        }
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
