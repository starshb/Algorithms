class Solution {
    fun solution(keyinput: Array<String>, board: IntArray): IntArray {
        val answer: IntArray = intArrayOf(0, 0)
        val list = keyinput.toList()
        for (i in list) {
            when (i) {
                "left" -> {
                    if (answer[0] <= -(board[0] / 2)) {
                        continue
                    }
                    answer[0] -= 1
                }
                "right" -> {
                    if (answer[0] >= board[0] / 2) {
                        continue
                    }
                    answer[0] += 1
                }
                "up" -> {
                    if (answer[1] >= board[1] / 2) {
                        continue
                    }
                    answer[1] += 1
                }
                "down" -> {
                    if (answer[1] <= -(board[1] / 2)) {
                        continue
                    }
                    answer[1] -= 1
                }
            }
        }

        return answer
    }
}