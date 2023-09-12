class Solution {
    fun solution(polynomial: String): String {
        var xCount = 0
        var num = 0

        for (s in polynomial.split(" ".toRegex())) {
            if (s.contains("x")) {
                xCount += if (s == "x") 1 else s.replace("x".toRegex(), "").toInt()
            } else if (s != "+") {
                num += s.toInt()
            }
        }
        return (if (xCount != 0) if (xCount > 1) "${xCount}x" else "x" else "") + if (num != 0) (if (xCount != 0) " + " else "") + num else if (xCount == 0) "0" else ""
    }
}