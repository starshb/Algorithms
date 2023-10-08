class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] answ = new int[10];
        
        for(int i=0; i<numbers.length; i++) {
            answ[numbers[i]] = 1;
        }

        for(int i=0; i<answ.length; i++) {
            if(answ[i] == 0) answer += i;
        }
        
        
        
        return answer;
    }
}