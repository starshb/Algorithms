class Solution {
    fun solution(n: Int) = (1..n).filter { i -> (1..i).filter { i % it == 0 }.size > 2 }.size
}