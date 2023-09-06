class Solution {
    fun solution(order: Int) = order.toString().map { it.digitToInt() }
        .count { it != 0 && it % 3 == 0 }
}