class Solution {
    fun solution(board: Array<IntArray>): Int {
        var answer = 0
        val wrapBoard = Array(board.size + 2) { IntArray(board[0].size + 2) }

        for (i in wrapBoard.indices) {
            for (j in wrapBoard[i].indices) {
                if (i == 0 || j == 0 || i == wrapBoard.size - 1 || j == wrapBoard[0].size - 1) {
                    wrapBoard[i][j] = 1
                }
                if (i > 0 && i < wrapBoard.size - 1 && j > 0 && j < wrapBoard[0].size - 1) {
                    if (board[i - 1][j - 1] == 1) {
                        wrapBoard[i][j] = 1
                        wrapBoard[i - 1][j - 1] = 1
                        wrapBoard[i - 1][j] = 1
                        wrapBoard[i - 1][j + 1] = 1
                        wrapBoard[i][j - 1] = 1
                        wrapBoard[i][j + 1] = 1
                        wrapBoard[i + 1][j - 1] = 1
                        wrapBoard[i + 1][j] = 1
                        wrapBoard[i + 1][j + 1] = 1
                    }
                }
            }
        }
        for (array in wrapBoard) {
            for (e in array) {
                if (e == 0) {
                    answer++
                }
            }
        }
        return answer
    }
}