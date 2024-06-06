package pt.isel.SHORT.client

/**
 * Represents the console object in JavaScript
 * Implementation according to [console - Web APIs | MDN](https://developer.mozilla.org/en-US/docs/Web/API/console)
 */
class Console(private val script: StringBuilder) {
    /**
     * Log an error message to console if the first argument is false.
     */
    fun assert(assertation: Boolean) {
        TODO()
    }

    /**
     * Clear the console.
     */
    fun clear() {
        script.append("console.clear()")
    }

    /**
     * Log the number of times this line has been called with the given label.
     */
    fun count() {
        TODO()
    }

    /**
     * Resets the value of the counter with the given label.
     */
    fun countReset() {
        TODO()
    }

    /**
     * Outputs a message to the console with the log level debug.
     */
    fun debug(message: String) {
        TODO()
    }

    /**
     * Displays an interactive listing of the properties of a specified JavaScript object.
     * This listing lets you use disclosure triangles to examine the contents of child objects.
     */
    fun dir() {
        TODO()
    }

    /**
     * Displays an XML/HTML Element representation of the specified object if possible
     * or the JavaScript Object view if it is not possible.
     */
    fun dirxml() {
        TODO()
    }

    /**
     * Outputs an error message. You may use string substitution and additional arguments with this method.
     */
    fun error(message: String) {
        TODO()
    }

    /**
     * Outputs an error message. You may use string substitution and additional arguments with this method.
     */
    fun error() {
        TODO()
    }

    /**
     * Creates a new inline group, indenting all following output by another level.
     * To move back out a level, call [groupEnd].
     */
    fun group() {
        TODO()
    }

    /**
     * Creates a new inline group, indenting all following output by another level.
     * However, unlike [group] these starts with the inline group collapsed requiring the use of a disclosure button to expand it.
     * To move back out a level, call [groupEnd].
     */
    fun groupCollapsed() {
        TODO()
    }

    /**
     * Exits the current inline group.
     */
    fun groupEnd() {
        TODO()
    }

    /**
     * Informative logging of information. You may use string substitution and additional arguments with this method.
     */
    fun info(message: String) {
        TODO()
    }

    /**
     * For general output of logging information. You may use string substitution and additional arguments with this method.
     */
    fun log(message: String) {
        script.append("console.log(\"$message\");")
    }

    fun <T> log(variable: Variable<T>) {
        script.append("console.log(${variable.reference});")
    }

    /**
     * Displays tabular data as a table.
     */
    fun table() {
        TODO()
    }

    /**
     * Starts a timer with a name specified as an input parameter.
     * Up to 10,000 simultaneous timers can run on a given page.
     */
    fun time() {
        TODO()
    }

    /**
     * Stops the specified timer and logs the elapsed time in milliseconds since it started.
     */
    fun timeEnd() {
        TODO()
    }

    /**
     * Logs the value of the specified timer to the console.
     */
    fun timeLog() {
        TODO()
    }

    /**
     * Outputs a stack trace.
     */
    fun trace() {
        TODO()
    }

    /**
     * Outputs a warning message. You may use string substitution and additional arguments with this method.
     */
    fun warn() {
        TODO()
    }
}
