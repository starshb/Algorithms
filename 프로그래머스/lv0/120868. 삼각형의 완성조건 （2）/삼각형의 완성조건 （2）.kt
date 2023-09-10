class Solution {
    fun solution(sides: IntArray): Int {
        val bigValue = Math.max(sides[0], sides[1])
        val smallValue = Math.min(sides[0], sides[1])

        val lowLimit = bigValue - smallValue
        val highLimit = bigValue + smallValue

        return highLimit - lowLimit - 1
    }
}