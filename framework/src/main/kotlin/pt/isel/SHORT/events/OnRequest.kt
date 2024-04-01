package pt.isel.SHORT.events

import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.element.HtmlReceiver

fun Tag.onRequest(callback: HtmlReceiver) {
    appendEvent(callback)
}
