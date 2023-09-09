import kotlin.math.abs

class Solution {
    fun solution(numList: IntArray, n: Int): IntArray {
        return numList.sortedWith { a, b ->
            if (abs(a - n) == abs(b - n)) b.compareTo(a) else abs(a - n).compareTo(abs(b - n))
        }.toIntArray()
    }
}