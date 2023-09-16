class Solution {
    fun solution(n: Int) = (2..n).find { n < factorial(it) }?.dec() ?: n

    private tailrec fun factorial(n: Int, run: Int = 1): Int = if (n == 1) run else factorial(n - 1, run * n)
}