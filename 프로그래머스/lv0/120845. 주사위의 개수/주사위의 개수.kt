class Solution {
    fun solution(box: IntArray, n: Int): Int {
        val a = box[0] / n
        val b = box[1] / n
        val c = box[2] / n

        return a * b * c
    }
}