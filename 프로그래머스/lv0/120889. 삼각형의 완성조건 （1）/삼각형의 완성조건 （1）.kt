class Solution {
    fun solution(sides: IntArray) = sides.sorted().let { (x, y, z) -> if (x + y > z) 1 else 2 }
}