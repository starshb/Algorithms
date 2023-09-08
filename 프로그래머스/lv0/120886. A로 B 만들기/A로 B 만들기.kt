class Solution {
    fun solution(before: String, after: String): Int =
        if (before.toList().sorted() == after.toList().sorted()) {
            1
        } else {
            0
        }
}