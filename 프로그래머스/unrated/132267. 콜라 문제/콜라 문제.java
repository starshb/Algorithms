class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int emptyCnt = n;
        
        while(a <= emptyCnt) {
            int changeCnt = emptyCnt / a * b;
            int remainderCnt = emptyCnt % a;
            
            answer += changeCnt;
            emptyCnt = changeCnt + remainderCnt;
            
        }
        
        return answer;
    }
}