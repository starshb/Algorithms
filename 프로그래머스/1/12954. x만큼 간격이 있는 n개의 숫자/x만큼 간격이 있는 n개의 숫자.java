class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        answer[0] = (long)x;
        for(int i = 1; i < n; i++) {
            answer[i] = answer[i-1] + (long)x;
        }

        return answer;
    }
}