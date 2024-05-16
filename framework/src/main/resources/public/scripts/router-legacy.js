var pages = {}

function registerPage(url, renderFunction) {
    pages[url] = renderFunction
}

function loadPage(url) {
    const page = pages[url]
    if (page) {
        document.body.innerHTML = page()
    }
}

function navigate(url) {
    window.history.pushState({}, '', url)
    loadPage(url)
}
