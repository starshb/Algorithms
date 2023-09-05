class Solution {
    fun solution(str: String): String = str.toCharArray()
        .map { if (it.isUpperCase()) it.toLowerCase() else it.toUpperCase() }
        .joinToString("")
}