class Solution {
    public int solution(int n) {
        int answer = fibo(n);
        System.out.println(answer);
        return answer;
    }
    
    public int fibo(int n) {
        int[] cache = new int[n+1];
        
        cache[0] = 0;
        cache[1] = 1;
        
        for (int i=2; i<= n; i++){
            // 99999와 같이 큰 수를 넣을 경우 int와 long타입의 범위를 넘어
            // 값들을 문제 조건에 맞게 1234567로 나눈 나머지로 저장
            cache[i] = (cache[i-1] + cache[i-2]) % 1234567;
        }
        
        return cache[n] % 1234567;
    }
}