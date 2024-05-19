package pt.isel.SHORT.client

fun JsScope(javaScript: JavaScript, jsHandler: JsHandler) {
    javaScript.apply(jsHandler)
}
