import java.util.*;

class Solution {
    public int[][] cost = {
        { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
        { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
        { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
        { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
        { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
        { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
        { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
        { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
        { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
        { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
    };

    public int[][][] dp; //dp[ind][left][right]
    public String arr;
    public int len;
    
    public int solve(int ind, int L, int R) {
        //기저 조건 
        if (ind == len) {
            return 0;
        }
        if (dp[ind][L][R] != -1) return dp[ind][L][R];
        
        int num = arr.charAt(ind) - '0';
        int result = Integer.MAX_VALUE;
        
        //왼쪽 손가락으로 움직이기 
        if (num != R) result = Math.min(solve(ind+1, num, R) + cost[L][num], result);
        
        //오른 손가락으로 움직이기
        if (num != L) result = Math.min(solve(ind+1, L, num) + cost[R][num], result);
        return dp[ind][L][R] = result;
    }
    
    public int solution(String numbers) {
        arr = numbers;
        len = numbers.length();
        //초기화 
        dp = new int[len + 1][10][10];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < 10; j++)
                Arrays.fill(dp[i][j], -1);
        }
        return solve(0, 4, 6);
    }
}