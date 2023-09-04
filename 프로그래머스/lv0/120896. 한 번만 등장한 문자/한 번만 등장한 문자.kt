class Solution {
    fun solution(s: String): String {
        var answer = ""
        val arr = IntArray(26)
        for (i in 0..25) {
            arr[i] = 0
        }
        for (element in s) {
            arr[element.code - 97] += 1
        }
        for (i in 0..25) {
            if (arr[i] == 1) {
                answer += (i + 97).toChar()
            }
        }
        return answer
    }
}