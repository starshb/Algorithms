import java.util.*

class Solution {
    fun solution(s: String): Int {
        var answer = 0
        val stack = Stack<Int>()

        for (w in s.split(" ".toRegex())) {
            if (w == "Z") {
                stack.pop()
            } else {
                stack.push(w.toInt())
            }
        }
        for (i in stack) {
            answer += i
        }
        return answer
    }
}