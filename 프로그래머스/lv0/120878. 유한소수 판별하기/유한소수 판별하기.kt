class Solution {
    fun solution(a: Int, b: Int): Int {
        var newB = b / gcd(a, b)
        while (newB != 1) {
            newB /= if (newB % 2 == 0) {
                2
            } else if (newB % 5 == 0) {
                5
            } else {
                return 2
            }
        }
        return 1
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) {
            a
        } else {
            gcd(b, a % b)
        }
    }
}