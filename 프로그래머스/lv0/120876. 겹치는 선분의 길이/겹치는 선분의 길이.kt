class Solution {
    fun solution(lines: Array<IntArray>): Int {
        var answer: Int = 0

        val map: MutableMap<String, Int> = HashMap()

        for (line in lines) {
            val tempMin = Math.min(line[0], line[1])
            val tempMax = Math.max(line[0], line[1])
            for (i in tempMin + 1 until tempMax + 1) {
                val str = (i - 1).toString() + "/" + i
                map[str] = map.getOrDefault(str, 0) + 1
            }
        }

        for (value in map.values) {
            if (value > 1) answer++
        }

        return answer
    }
}