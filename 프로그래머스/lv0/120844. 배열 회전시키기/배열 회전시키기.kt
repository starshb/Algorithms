import java.util.Collections

class Solution {
    fun solution(numbers: IntArray, direction: String): IntArray {
        val aList = numbers.toList()
        if (direction == "right") {
            Collections.rotate(aList, 1)
        } else {
            Collections.rotate(aList, -1)
        }
        
        return aList.toIntArray()
    }
}