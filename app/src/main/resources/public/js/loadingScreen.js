const page = `<html><body>${document.body.innerHTML}</body></html>`

async function checkLoadingState() {
    console.log("Checking loading state...")
    const response = await fetch("http://localhost:9000")
    const text = await response.text()
    if (text != page) {
        // document.documentElement.innerHTML = page
        location.reload()
    }
    else {
        start()
    }
}

function start() {
    setTimeout(checkLoadingState, 1000)
}
start()
