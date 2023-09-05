class Solution {
    fun solution(numbers: String): Long {
        val map = mapOf(
            "zero" to "0",
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9"
        )
        var result = numbers
        map.forEach { 
            result = result.replace(it.key, it.value)
        }
        
        return result.toLong()
    }
}