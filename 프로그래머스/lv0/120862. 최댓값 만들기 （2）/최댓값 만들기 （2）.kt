class Solution {
    fun solution(numbers: IntArray): Int {
        val list = numbers.toList()
        val answer = list.flatMapIndexed { index: Int, a: Int ->
            list.subList(index + 1, list.size).map { b -> a * b }
        }.maxOf { it }

        return answer
    }
}