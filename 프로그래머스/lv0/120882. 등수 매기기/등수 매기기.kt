class Solution {
    fun solution(score: Array<IntArray>): IntArray {
        return score.map(IntArray::average).map { score.map(IntArray::average).sortedDescending().indexOf(it) + 1 }
            .toIntArray()
    }
}