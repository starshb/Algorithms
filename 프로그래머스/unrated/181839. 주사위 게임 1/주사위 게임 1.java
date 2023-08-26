class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        if(a%2==1&&b%2==1){//모두 홀수
            answer = a*a+b*b;
        }else if(a%2==1||b%2==1){//하나만 홀수
            answer = 2*(a+b);
        }else{//짝수
            answer = Math.abs(a-b);
        }
        
        return answer;
    }
}