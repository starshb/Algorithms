class Solution {
    long[] tile = new long[5001];
    
    public long solution(int n) {
        long answer = 0;
        int mod=1000000007;
        //1:2, 2:3, 3:6 4:11
        // 규칙활용 f(n) = f(n-2)*4 - f(n-4)
        tile[0]=1;
        tile[2]=3;
        
        //f(n) = ((f(n - 2) x 4 % 1,000,000,007) 
        //- (f(n - 4) % 1,000,000,007) + 1,000,000,007) % 1,000,000,007
       for(int i=4; i<=n; i+=2){
           tile[i]= (tile[i-2]*4%mod -tile[i-4]%mod +mod)%mod;
        
        };
        
        return answer=tile[n];
    }
    
  
}