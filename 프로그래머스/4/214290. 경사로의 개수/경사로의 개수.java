import java.util.*;

class Solution {
    
    static int MOD = 1000000007;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    
    
    public int solution(int[][] grid, int[] d, int k) {
        
   
        int n =grid.length;
        int m = grid[0].length;
        int dl = d.length;
        
        //dp[순서][출발칸][목적지칸]
        long dp[][][] = new long[dl+1][n*m][n*m];        
        
        for(int i = 0; i < n*m; i++){
            dp[0][i][i] =  1;   
        }
        
        for(int l = 1; l <= dl; l++){
            for(int i = 0; i < n*m; i++){
                int x = i % m;
                int y = i / m;
                
                for(int dir = 0; dir < 4; dir++){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n || grid[ny][nx] - grid[y][x] != d[l-1] ){
                        continue;
                    }
                    
                    for(int j = 0; j < n*m; j++){
                        dp[l][j][ny*m + nx] += dp[l-1][j][i] % MOD;
                        dp[l][j][ny*m + nx] %= MOD;
                    }
                }
            }
        }
        
        int count = 0;
        while(Math.pow(2, count) < k ){
            count++;
        }
        
        long edgePower[][][] = new long[count+1][n*m][n*m];
        edgePower[0] = dp[dl];
        for(int c = 1; c <= count ; c++){
            edgePower[c] = mulMatrix(edgePower[c-1], edgePower[c-1]);
        }
        
        
        long mat[][] = new long[n*m][n*m];
        for(int i =0; i < n*m; i++){
            mat[i][i] = 1;
        }
        
        int kNum = k;
        while(kNum > 0){
            if(kNum >= Math.pow(2, count)){
                mat = mulMatrix(mat, edgePower[count]);
                kNum -= Math.pow(2, count);
            }
            count --;
        }    
    
        long answer = 0;
        for(int i = 0; i <n*m; i++){
            for(int j = 0; j < n*m; j++){
                answer += mat[i][j];
                answer %= MOD;
            }
        }
        
        return (int)answer;
    }
    
    static long[][] mulMatrix(long[][] a, long[][] b){
        int n = a.length;
        long[][] result = new long[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    result[i][j] += ((a[i][k] % MOD) * (b[k][j] % MOD))% MOD;
                }
            }
        }
        
        return result;
    }
    
}