package pt.isel.SHORT.serverEvents

import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag

/**
 * This allows to write code that will be executed when the client requests the application.
 * @param callback the code to be executed when the client makes a request.
 * Each time the client requests for the application, the callback will be executed.
 */
fun Tag.onRequest(callback: HtmlReceiver) {
    appendEvent(callback)
}
