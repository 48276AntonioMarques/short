// This file contains the dom manipulation functions for the game.

function renderPiece(index, piece) {
    const squares = document.getElementsByClassName("square")
    squares[index].innerText = piece
}

function renderText(newText) {
    const text = document.getElementById("game-text")
    text.innerText = newText
}

function updatePreviews(nextPiece) {
    const previews = document.getElementsByClassName("preview")
    for (let i = 0; i < previews.length; i++) {
        switch (nextPiece) {
            case "X":
                previews[i].innerText = "X"
                break
            case "O":
                previews[i].innerText = "O"
                break
            case "EMPTY":
                previews[i].innerText = ""
                break
            default:
                console.error("Try to preview an invalid piece: ", nextPiece)
        }
    }
}

function removePreviewHover() {
    const previews = document.getElementsByClassName("square")
    for (let i = 0; i < previews.length; i++) {
        previews[i].style = "filter: brightness(80%);cursor: default;"
    }
}
