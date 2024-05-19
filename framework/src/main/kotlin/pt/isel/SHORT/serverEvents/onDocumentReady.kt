package pt.isel.SHORT.serverEvents

import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag

/**
 * This allows to write code that will be executed when the client requests the application.
 * @param callback the code to be executed when the wepApp is already created.
 */
fun Tag.onDocumentReady(callback: HtmlReceiver) {
    val docReadyEvent = DocumentReadyEvent(this, callback)
    scope.registerDocReadyEvent(docReadyEvent)
}

class DocumentReadyEvent(val context: Tag, val eventHandler: HtmlReceiver) {
    fun run() {
        context.eventHandler(context.scope)
    }
}
