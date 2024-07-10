let isRendering = false

async function loadPage(url) {
    const templates = document.getElementsByTagName("template")
    const template = templates["page-" + url]
    if (template) {
        while (isRendering) {
            // Wait for the current page to finish rendering
            await new Promise(resolve => setTimeout(resolve, 10))
        }
        isRendering = true
        const page = template.content.cloneNode(true)
        const app = document.body
        while (app.firstChild) {
            app.removeChild(app.firstChild)
        }
        for(let child of page.childNodes) {
            let clone = child.cloneNode(true);
            app.appendChild(clone);
        }
        isRendering = false
        return true
    }
    else {
        // TODO: 404 page
        console.log("Page not found: " + url)
        return false
    }
}

async function navigate(url) {
    const success = await loadPage(url)
    if (success) {
        window.history.pushState({}, '', url)
    }
}

window.addEventListener("load", () => {
    loadPage(window.location.pathname)
})
