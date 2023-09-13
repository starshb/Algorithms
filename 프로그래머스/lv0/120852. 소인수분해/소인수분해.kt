class Solution {
    fun solution(n: Int): IntArray {
        var num = n
        val list: MutableList<Int> = ArrayList()
        var i = 2

        while (num >= 2) {
            if (num % i == 0) {
                list.add(i)
                num /= i
            } else {
                i++
            }
        }
        
        return list.stream().distinct().mapToInt { obj: Int -> obj }.toArray()
    }
}