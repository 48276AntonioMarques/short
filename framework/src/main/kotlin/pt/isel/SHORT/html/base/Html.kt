package pt.isel.SHORT.html.base

import pt.isel.SHORT.AggregationMode
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Element
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.HtmlScope
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype
import pt.isel.SHORT.html.element.Script
import pt.isel.SHORT.serverEvents.onDocumentReady

class Html : Element {
    val scope = HtmlScope(this)

    val tag = Tag("html", emptyList(), scope, emptyList())
    var head: Tag? = null
        private set
    var body: Tag? = null
        private set

    init {
        // In here the tag is already created
        // So we can already run the events from onDocumentReady
        scope.runDocReadyEvents()
    }

    var aggregationMode: AggregationMode = AggregationMode.TEMPLATE
        private set

    fun using(aggregationMode: AggregationMode): Html {
        this.aggregationMode = aggregationMode
        return this
    }

    fun setHead(head: Tag) {
        this.head = head
    }

    fun setBody(body: Tag) {
        this.body = body
    }

    override fun toHtml(): String {
        return tag.toHtml()
    }

    override fun innerHtml(): String {
        return tag.innerHtml()
    }
}

fun Html(content: Html.() -> Unit) =
    Html().apply(content)

fun Html.Head(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = tag.apply {
    val head = prototype("head", attributes, scope, content)
    val eventHandlers = Script {
        onDocumentReady {
            Text {
                scope.eventHandlersToHtml()
            }
        }
    }
    head.appendChild(eventHandlers)
    val globalScript = Script {
        onDocumentReady {
            Text {
                scope.globalScript.toHtml()
            }
        }
    }
    head.appendChild(globalScript)
    appendChild(head)
    setHead(head)
}

fun Html.Body(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = tag.apply {
    val body = prototype("body", attributes, scope, content)
    appendChild(body)
    setBody(body)
}
