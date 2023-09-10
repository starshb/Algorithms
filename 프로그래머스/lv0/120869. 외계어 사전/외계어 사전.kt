class Solution {
    fun solution(spell: Array<String>, dic: Array<String>) = if (dic.map { it.toList().sorted().joinToString("") }.contains(spell.sortedArray().joinToString(""))) 1 else 2
}