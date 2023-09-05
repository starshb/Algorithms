import java.util.*

class Solution {
    fun solution(myString: String, num1: Int, num2: Int): String {
        return myString.toList().let {
            Collections.swap(it, num1, num2)
            it.joinToString("")
        }
    }
}