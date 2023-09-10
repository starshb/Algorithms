class Solution {
    fun solution(n: Int): Int {
        var answer = n
        var i = 1
        while (i <= answer) {
            if ((i % 3 == 0) || i.toString().contains("3")) {
                answer++
            }
            i++
        }

        return answer
    }
}