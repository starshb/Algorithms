class Solution {
    fun solution(numbers: IntArray): Int = numbers.sorted().takeLast(2).fold(1) { acc, i -> acc * i }
}