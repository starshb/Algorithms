class Solution {
    public String solution(String my_string, int s, int e) {
        char[] charArray = my_string.toCharArray(); // 문자열을 char 배열로 변환

        while (s < e) { // s와 e를 이용하여 배열을 뒤집음
            char temp = charArray[s];
            charArray[s] = charArray[e];
            charArray[e] = temp;
            s++;
            e--;
        }

        return new String(charArray); // 뒤집힌 배열을 다시 문자열로 변환하여 반환
    }
}