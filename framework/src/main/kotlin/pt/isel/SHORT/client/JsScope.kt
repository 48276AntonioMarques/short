package pt.isel.SHORT.client

import pt.isel.SHORT.html.base.Html

/**
 * Used to create a scope for JavaScript code.
 * @param javaScript The JavaScript object that will be used to write the JavaScript code.
 * @sample JsScopeSample
 */
fun JsScope(javaScript: JavaScript, jsHandler: JsHandler) {
    javaScript.jsHandler()
}

private fun JsScopeSample() {
    Html {
        JsScope(scope.globalScript) {
            console.log("Hello, world!")
        }
    }
}
