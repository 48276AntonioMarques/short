function loadPage(url) {
    const templates = document.getElementsByTagName("template")
    const template = templates["page-" + url]
    if (template) {
        const page = template.content.cloneNode(true)
        const app = document.body
        while (app.firstChild) {
            app.removeChild(app.firstChild)
        }
        for(let child of page.childNodes) {
            let clone = child.cloneNode(true);
            app.appendChild(clone);
        }
    }
    else {
        // TODO: 404 page
        console.log("Page not found: " + url)
    }
}

function navigate(url) {
    window.history.pushState({}, '', url)
    loadPage(url)
}

window.addEventListener("load", () => {
    loadPage(window.location.pathname)
})
