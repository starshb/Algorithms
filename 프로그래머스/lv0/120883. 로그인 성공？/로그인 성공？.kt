class Solution {
    fun solution(idPw: Array<String>, db: Array<Array<String>>) =
        db.associate { (k, v) ->
            k to v
        } [idPw[0]]?.run {
            if (equals(idPw[1])) "login"
            else "wrong pw"
        } ?: "fail"
}