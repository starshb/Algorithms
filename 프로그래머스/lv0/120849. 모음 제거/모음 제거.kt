class Solution {
    fun solution(myString: String) = myString.replace("a|e|i|o|u".toRegex(), "")
}