package pt.isel.SHORT.css

/**
 * This annotation is used to reference a CSS file required by component.
 * Such file MUST be inside /resources/public/ or otherwise accessible by the web.
 */
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Import(val path: String)
