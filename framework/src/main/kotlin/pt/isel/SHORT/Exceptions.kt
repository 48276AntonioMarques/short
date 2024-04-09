package pt.isel.SHORT

/**
 * Exception thrown when the class loader fails to load a class.

 */
class ClassLoaderException(message: String, cause: Throwable) : RuntimeException(message, cause)

/**
 * Exception thrown when a provided page doesn't exist in the classpath.
 */
class PageNotFoundException(message: String) : RuntimeException(message)

/**
 * Exception thrown when a page is not correctly linked.
 * This happens when a page is provided without the @[Page] annotation.
 */
class PageLinkageException(message: String) : RuntimeException(message)

/**
 * Exception thrown when a resource is not found.
 */
class ResourceNotFoundException(message: String) : RuntimeException(message)

/**
 * Exception thrown when cause is handled but the client should be notified.
 */
class JavaScriptException(message: String) : RuntimeException(message)

/**
 * Exception thrown when the browser is not supported.
 */
class BrowserNotSupportedException(message: String) : RuntimeException(message)

/**
 * Exception thrown when the template aggregation mode is not supported.
 */
class TemplateAggregationException(message: String) : RuntimeException(message)
