class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        
        // n이 s보다 크면 불가능
        if(n > s) {
            answer = new int[]{-1};
            return answer;
        }
        
        int init = s / n; // 몫
        int mod = s % n; // 나머지
        
        answer = new int[n];
        // 몫으로 모든 값을 초기화
        for(int i = 0; i < n; i++) {
            answer[i] = init;
        }
        
        // 나머지 만큼 뒤에서부터(오름차순 정렬이 되게) 1씩 더해줌
        int idx = n - 1;
        for(int m = 0; m < mod; m++) {
            answer[idx]++;
            idx--;
        }
        
        return answer;
    }
}