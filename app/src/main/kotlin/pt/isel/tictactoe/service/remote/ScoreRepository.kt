package pt.isel.tictactoe.service.remote

enum class GameResult(val points: Int) {
    WIN(6),
    DRAW(3),
    LOSE(1)
}

data class Leaderboard(val scores: List<ScoreEntry>)
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
        // Offset is the index of the first element of the page
        // If the page is out of bounds, the offset is begging of the last page according to the page size
        val offset = if (page * pageSize >= scores.size) (scores.size / pageSize) * pageSize else page * pageSize
        val length = if (offset + pageSize > scores.size) offset + pageSize + (scores.size - offset) else offset + pageSize
        scores.subList(offset, length).let {
            return Leaderboard(it)
        }
    }
}
