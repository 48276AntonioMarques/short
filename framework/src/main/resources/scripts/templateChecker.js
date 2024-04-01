function checkTemplateSupport() {
    if ("content" in document.createElement("template")) {

    }
    else {
        document.getElementById("app").innerHTML = "Your browser does not support templates."
    }
}
checkTemplateSupport()
