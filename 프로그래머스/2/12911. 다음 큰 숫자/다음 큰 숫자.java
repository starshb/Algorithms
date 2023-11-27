class Solution {
    public int solution(int n) {
        int answer = 0;
        // 1. 입력받은 n의 1 개수를 저장.
        int n_cnt = Integer.bitCount(n);
        // 2. 증가하는 n의 1 개수를 저장 할 변수.
        int b_cnt = 0;
        // 3. 무한반복.
        while(true){
            // 4. n을 증가.
            n++;
            // 5. 증가된 n의 1 개수를 저장.
            b_cnt = Integer.bitCount(n);
            // 6. 일치하면, answer에 n을 담고 반복문을 빠져나온다.
            if(n_cnt == b_cnt){
                answer = n;
                break;
            }            
        }
                
        return answer;
    }
}