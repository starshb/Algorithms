class Solution {
    fun solution(dots: Array<IntArray>): Int =
    dots.sortedWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        .let { (A, _, _, B) ->
            (B[0] - A[0]) * (B[1] - A[1])
        }
}