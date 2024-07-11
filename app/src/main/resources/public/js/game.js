/*
 * This file contains all the logic for the game
 * The logic for this game is based on: https://github.com/48276AntonioMarques/pogersbot/blob/main/modules/tiktoktoe.js
*/

function setPiece(game, position) {
    // Check if the game is over
    if (game.winner !== "EMPTY") return;
    // Check if the square is empty
    const index = positionToIndex(position)
    const square = game.board[index]
    if (square !== "EMPTY") return;
    // If the game is not over place piece
    game.board[index] = game.nextPiece
    renderPiece(index, game.nextPiece)
    // Check if the game is over
    const winner = checkWinner(game)
    if (winner === "EMPTY") {
        // Update nextPiece
        game.nextPiece = game.nextPiece === "X" ? "O" : "X"
        updatePreviews(game.nextPiece)
    }
    else {
        game.winner = winner
    }
    updateText(game)
}

function checkWinner(game) {
    var winner = "EMPTY"
    game.winningConditions.forEach((condition) => {
        const a = condition.first
        const b = condition.second
        const c = condition.third
        const result = game.board[a] === game.board[b] && game.board[b] === game.board[c] && game.board[a] !== "EMPTY"
        if (result) {
            winner = game.board[a]
            return;
        }
    })
    if (this.leftRounds <= 0){
        return "TIE";
    }
    return winner;
}

function renderPiece(index, piece) {
    const squares = document.getElementsByClassName("square");
    squares[index].innerText = piece
}

function updateText(game) {
    const text = document.getElementById("game-text");
    // Check if the game is over
    const winner = game.winner
    switch (winner) {
        case "X":
            text.innerText = `${game.player1.username} wins!`
            break;
        case "O":
            text.innerText = `${game.player2.username} wins!`
            break;
        case "TIE":
            text.innerText = "It's a tie!"
            break;
        case "EMPTY":
        default:
            // Display next piece
            const nextPlayer = game.nextPiece === "X" ? game.player1.username : game.player2.username
            text.innerText = `It's ${nextPlayer}'s turn.`
            break;
    }
}

function updatePreviews(nextPiece) {
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

function positionToIndex(position) {
    const height = position.height
    const side = position.side
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
    return index
}
