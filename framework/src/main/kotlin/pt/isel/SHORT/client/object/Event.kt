package pt.isel.SHORT.client.`object`

import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.client.JsObject
import pt.isel.SHORT.client.Variable

class Event(private val script: JavaScript) : JsObject {
    override fun toJs(): String = "event"

    // TODO: Register the literal value of the object inside the scope of the event script
    /**
     * A boolean value indicating whether the event bubbles up through the DOM.
     */
    val bubbles = script.registerProperty(false, "${toJs()}.bubbles;")

    /**
     * A boolean value indicating whether the event is cancelable.
     */
    val cancelable = script.registerProperty(false, "${toJs()}.cancelable;")

    /**
     * A boolean indicating whether the event can bubble across the boundary between the shadow DOM and the regular DOM.
     */
    val composed = script.registerProperty(false, "${toJs()}.composed;")

    /**
     * A reference to the currently registered target for the event.
     * This is the object to which the event is currently slated to be sent.
     * It's possible this has been changed along the way through retargeting.
     */
    val currentTarget = script.registerProperty(Any(), "${toJs()}.currentTarget;")

    /**
     * Indicates whether the call to event.preventDefault() canceled the event.
     */
    val defaultPrevented = script.registerProperty(false, "${toJs()}.defaultPrevented;")

    /**
     * Indicates which phase of the event flow is being processed.
     * It is one of the following numbers: NONE, CAPTURING_PHASE, AT_TARGET, BUBBLING_PHASE.
     */
    val eventPhase = script.registerProperty(EventPhase.NONE, "${toJs()}.eventPhase;")

    /**
     * Indicates whether the event was initiated by the browser (after a user click, for instance)
     * or by a script (using an event creation method, for example).
     */
    val isTrusted = script.registerProperty(false, "${toJs()}.isTrusted;")

    /**
     * A reference to the object to which the event was originally dispatched.
     */
    val target = Target("${toJs()}.target", script)

    /**
     * The name identifying the type of the event.
     */
    val type = script.registerProperty("", "${toJs()}.type;")

    /**
     * Returns the event's path (an array of objects on which listeners will be invoked).
     * This does not include nodes in shadow trees if the shadow root was created with its ShadowRoot.mode closed.
     */
    fun composedPath(result: Variable<*>) {
        script.append("${result.reference} = ${toJs()}.composedPath();")
    }

    /**
     * Cancels the event (if it is cancelable).
     */
    fun preventDefault() {
        script.append("${toJs()}.preventDefault();")
    }

    /**
     * For this particular event, prevent all other listeners from being called.
     * This includes listeners attached to the same element
     * as well as those attached to elements that will be traversed later (during the capture phase, for instance).
     *
     */
    fun stopImmediatePropagation() {
        script.append("${toJs()}.stopImmediatePropagation();")
    }

    /**
     * Stops the propagation of events further along in the DOM.
     */
    fun stopPropagation() {
        script.append("${toJs()}.stopPropagation();")
    }
}
