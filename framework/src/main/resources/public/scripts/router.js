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
        return true
    }
    else {
        // TODO: 404 page
        console.log("Page not found: " + url)
        return false
    }
}

function navigate(url) {
    const success = loadPage(url)
    if (success) {
        window.history.pushState({}, '', url)
    }
}

window.addEventListener("load", () => {
    loadPage(window.location.pathname)
})
