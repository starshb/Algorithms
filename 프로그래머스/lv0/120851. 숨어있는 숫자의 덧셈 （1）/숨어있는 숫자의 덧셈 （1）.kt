class Solution {
    fun solution(str: String) = str.filter { Character.isDigit(it) }.sumOf { it.digitToInt() }
}