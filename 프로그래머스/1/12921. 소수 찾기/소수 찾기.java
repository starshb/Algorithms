class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] number = new int[n+1];
        
        for(int i = 0; i < n+1; i++) number[i] = i;
        
        for(int i = 2; i < n+1; i++) {
            if(number[i] != 0) {
                for(int j=i+i; j<n+1; j+=i) {
                    number[j] = 0;
                }
            }
        }
        
        for(int i = 2; i < n+1; i++) {
            if(number[i] != 0) answer++;
        }
        
        return answer;
    }
}