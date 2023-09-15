class Solution {
    fun solution(str: String) = str.replace("[A-Z|a-z]".toRegex(), "")
        .toList()
        .sorted()
        .map { it.toString().toInt() }
        .toIntArray()
}