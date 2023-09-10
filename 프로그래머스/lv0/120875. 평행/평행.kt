import kotlin.math.abs

class Solution {
    fun solution(dots: Array<IntArray>): Int {
        var answer = 0

        val x1 = dots[0][0]
        val y1 = dots[0][1]
        val x2 = dots[1][0]
        val y2 = dots[1][1]
        val x3 = dots[2][0]
        val y3 = dots[2][1]
        val x4 = dots[3][0]
        val y4 = dots[3][1]

        if (abs((x1 - x2) * (y3 - y4)) == abs((y1 - y2) * (x3 - x4))) {
            return 1
        }
        if (abs((x1 - x3) * (y2 - y4)) == abs((y1 - y3) * (x2 - x4))) {
            return 1
        }
        if (abs((x1 - x4) * (y2 - y3)) == abs((y1 - y4) * (x2 - x3))) {
            return 1
        }
        return 0
    }
}