class Solution {
    fun solution(i: Int, j: Int, k: Int): Int = (i .. j).joinToString("").count { it.digitToInt() == k }
}