function populateLeaderboard(leaderboard) {
    const tbody = document.getElementsByTagName("tbody")[0]

    leaderboard.scores.forEach(({place, username, totalPoints}) => {
        const tr = document.createElement("tr")
        tbody.appendChild(tr)
        const tdPlace = document.createElement("td")
        tdPlace.innerText = place
        tr.appendChild(tdPlace)
        const tdUsername = document.createElement("td")
        tdUsername.innerText = username
        tr.appendChild(tdUsername)
        const tdPoints = document.createElement("td")
        tdPoints.innerText = totalPoints
        tr.appendChild(tdPoints)
    })
}