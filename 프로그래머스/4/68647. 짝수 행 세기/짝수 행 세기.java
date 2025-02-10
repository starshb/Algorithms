import java.util.*;

class Solution {
    static long MOD = 10000019;
    static long comb[][];
    
    public int solution(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        
        int ones[] = new int[m];
        int sum = 0;
        for(int x = 0; x < m; x++){
            for(int y = 0; y < n; y++){
                if(a[y][x] == 1){
                    ones[x] ++;
                    sum++;
                }
            }
        }
        
        if(sum % 2 == 1){
            return 0;
        }
        
        //[열][1 개수가 홀수인 행의 수]
        long dp[][] = new long[m][n+1];
        comb = new long[n+1][n+1];
        
        dp[0][ones[0]] = combination(n, ones[0]);
        
        for(int i = 1; i < m; i++){
            for(int j = 0; j <= n; j++){
                if(dp[i-1][j] == 0){
                    continue;
                }    
                int o = ones[i];
            
                // oo -> 홀수인 행에 배치하는 1의 수
                for(int oo = Math.max(0, o - n + j); oo <= Math.min(o, j); oo++){
                    dp[i][j - oo + (o - oo)] +=  (dp[i-1][j] * 
                                                  (combination(j, oo) * (combination(n - j, o - oo)) % MOD)) % MOD;
                    dp[i][j - oo + (o - oo)] %= MOD;    
                }
            }
        }

        return (int)dp[m-1][0];
    }
    
    static long combination(int a, int b){
        if(comb[a][b] != 0){
            return comb[a][b];
        }
        
        if(b == 0){
            return comb[a][b] = 1;
        }
        if(a == b){
            return comb[a][b] = 1;
        }
        
        return comb[a][b] = (combination(a-1,b-1) + combination(a-1, b)) % MOD;
    }
    
}