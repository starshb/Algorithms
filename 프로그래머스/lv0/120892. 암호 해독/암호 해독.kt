class Solution {
    fun solution(cipher: String, code: Int): String = cipher.split("").toList()
        .mapIndexed { index, s -> if (index % code == 0) s else "" }
        .joinToString("")
}