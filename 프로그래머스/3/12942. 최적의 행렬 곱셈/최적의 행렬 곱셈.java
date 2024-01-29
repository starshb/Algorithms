import java.util.*;

class Solution {
    public int N, INF = 987654321;
    public int[][] matrixs;
    public int[][] dp;

    //s인덱스부터 e인덱스까지 행렬을 곱했을 때 최소 횟수 리턴
    public int solve(int s, int e) {
        if (s == e) return 0;
        if (dp[s][e] != -1) return dp[s][e];

        int result = INF;
        //모든 구간 나눠보기
        for (int i = 0; i < e - s; i++) {
            int mid = s + i;
            int tmp = 0;
            tmp += solve(s, mid);
            tmp += solve(mid + 1, e);
            tmp += matrixs[s][0] * matrixs[mid][1] * matrixs[e][1];
            result = Math.min(result, tmp);
        }
        return dp[s][e] = result;
    }

    public int solution(int[][] matrix_sizes) {
        //초기화
        N = matrix_sizes.length;
        matrixs = matrix_sizes;
        dp = new int[N][N];
        for (int i = 0; i < N; i++) 
            Arrays.fill(dp[i], -1);

        //다이나믹 프로그래밍
        return solve(0, N-1);
    }
}