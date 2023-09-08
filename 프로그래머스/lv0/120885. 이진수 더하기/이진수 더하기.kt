class Solution {
    fun solution(bin1: String, bin2: String): String =
        Integer.toBinaryString(bin1.toInt(2) + bin2.toInt(2))
}