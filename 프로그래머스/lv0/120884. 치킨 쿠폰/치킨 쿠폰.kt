class Solution {
    fun solution(chicken: Int): Int{
        var left = chicken
        var answer = 0
        while (left >= 10) {
            answer += left / 10
            left = left / 10 + left % 10
        }
        return answer
    }
}