package pt.isel.tictactoe.service.remote

enum class GameResult(val points: Int) {
    WIN(6),
    DRAW(3),
    LOSE(1)
}

data class Leaderboard(val scores: List<BoardEntry>)
data class BoardEntry(val place: Int, val username: String, val totalPoints: Int)
data class ScoreEntry(val username: User, val gameResult: GameResult)

object ScoreRepository {
    private val scores = mutableListOf<ScoreEntry>(
        ScoreEntry(UserRepository.users["ethel"]!!, GameResult.DRAW),
        ScoreEntry(UserRepository.users["jose"]!!, GameResult.LOSE),
        ScoreEntry(UserRepository.users["luis"]!!, GameResult.WIN),
        ScoreEntry(UserRepository.users["marta"]!!, GameResult.DRAW),
        ScoreEntry(UserRepository.users["jose"]!!, GameResult.WIN),
        ScoreEntry(UserRepository.users["luis"]!!, GameResult.LOSE),
        ScoreEntry(UserRepository.users["marta"]!!, GameResult.WIN),
        ScoreEntry(UserRepository.users["ethel"]!!, GameResult.DRAW),
        ScoreEntry(UserRepository.users["jose"]!!, GameResult.DRAW),
        ScoreEntry(UserRepository.users["luis"]!!, GameResult.WIN),
        ScoreEntry(UserRepository.users["marta"]!!, GameResult.LOSE),
        ScoreEntry(UserRepository.users["ethel"]!!, GameResult.WIN),
        ScoreEntry(UserRepository.users["ethel"]!!, GameResult.WIN)
    )

    fun getLeaderboard(page: Int, pageSize: Int): Leaderboard {
        val board = scores.groupBy { it.username }
            .map { (user, gameResults) ->
                BoardEntry(
                    place = 0,
                    username = user.name,
                    totalPoints = gameResults.sumOf { it.gameResult.points }
                )
            }
            .sortedByDescending { it.totalPoints }
            .mapIndexed { index, boardEntry -> boardEntry.copy(place = index + 1) }

        // Offset is the index of the first element of the page
        // If the page is out of bounds, the offset is begging of the last page according to the page size
        if (page < 0 || pageSize <= 0) throw IllegalArgumentException("Invalid page or page size")
        val start = if (page * pageSize >= board.size) (board.size / pageSize) * pageSize else page * pageSize
        val length = if (start + pageSize >= board.size) board.size - start else pageSize
        return Leaderboard(board.subList(start, length))
    }
}
