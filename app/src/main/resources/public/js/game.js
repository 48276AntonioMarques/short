function setNextPiecePreview(nextPiece) {
    const previews = document.getElementsByClassName("preview");
    for (let i = 0; i < previews.length; i++) {
        if (nextPiece == "X") {
            previews[i].innerText = "X"
        }
        else {
            previews[i].innerText = "O"
        }

    }
}

function setPiece(piece, height, side) {
    const squares = document.getElementsByClassName("square");
    let index = 0
    if (height == "CENTER") {
        index = 3
    }
    else if (height == "BOTTOM") {
        index = 6
    }
    if (side == "CENTER") {
        index += 1
    }
    else if (side == "RIGHT") {
        index += 2
    }
    squares[index].innerText = piece
    if (piece == "X") {
        setNextPiecePreview("O")
    }
    else {
        setNextPiecePreview("X")
    }
}
