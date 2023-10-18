import java.util.Arrays;

class Solution {
    public int[] solution(long n) {
    
        String s = String.valueOf(n);
        
        int[] answer = new int[s.length()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(s.substring(answer.length-1-i, answer.length-i));
        }
        
        return answer;
    }
}