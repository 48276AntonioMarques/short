package pt.isel.SHORT.html.base.css

/**
 * This annotation is used to reference a file required by component.
 * @param relation the relation of the file, e.g. "stylesheet", "preload", "prefetch", etc.
 * @param type the type of the file, e.g. "text/css", "js", "font", etc.
 * @param path MUST be inside /resources/public/ or otherwise accessible by the web.
 */
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Import(val relation: String, val type: String, val path: String)
