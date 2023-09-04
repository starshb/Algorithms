class Solution {
    fun solution(n: Int): IntArray {
        val list = (1..n).toList()
        val result = arrayListOf<Int>()
        for (i in list) {
            if (n % i == 0) {
                println(i)
                result.add(i)
            }
        }

        return result.toIntArray()
    }
}