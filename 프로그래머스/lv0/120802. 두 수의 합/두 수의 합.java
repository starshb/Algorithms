class Solution {
    public int solution(int num1, int num2) {
        int answer = -1;

        if (num1 >= -50000 && num1 <= 50000 && num2 >= -50000 && num2 <= 50000) {
            answer = num1 + num2;
        }
        return answer;
    }
}