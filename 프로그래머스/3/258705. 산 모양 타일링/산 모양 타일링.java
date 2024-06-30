class Solution {
    public int solution(int n, int[] tops) {
        int mod = 10007;
        int[][] dp = new int[n][2];
        dp[0][0] = tops[0] == 1 ? 3 : 2; // (1)
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            int mul1 = tops[i] == 1 ? 3 : 2;
            int mul2 = tops[i] == 1 ? 2 : 1;
            dp[i][0] = (dp[i - 1][0] * mul1 + dp[i - 1][1] * mul2) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }
        return (dp[n - 1][0] + dp[n - 1][1]) % mod;
    }
}