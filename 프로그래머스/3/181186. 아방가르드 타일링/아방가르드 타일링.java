import java.util.*;

class Solution {
    public final int MOD = 1000000007;

    public int solution(int n) {
        long[] dp = new long[n + 1];
        long[] dp4 = new long[n + 1];
        long[] dp5 = new long[n + 1];
        long[] dp6 = new long[n + 1];
        dp[0] = 1;
        //가로 1 -> 1가지
        //가로 2 -> 2가지
        //가로 3 -> 5가지
        //가로 4, 7, 10... -> 2가지
        //가로 5, 8, 11... -> 2가지
        //가로 6, 9, 12... -> 4가지
        for (int i = 1; i <= n; i++) {
            if (i - 1 >= 0) dp[i] = (dp[i] + dp[i - 1]) % MOD;
            if (i - 2 >= 0) dp[i] = (dp[i] + dp[i - 2] * 2) % MOD;
            if (i - 3 >= 0) dp[i] = (dp[i] + dp[i - 3] * 5) % MOD;
            if (i - 4 >= 0) {
                long diff = (dp[i - 4] * 2) % MOD;
                dp4[i] = (dp4[i-3] + diff) % MOD;
                dp[i] = (dp[i] + dp4[i]) % MOD;
            }

            if (i - 5 >= 0) {
                long diff = (dp[i - 5] * 2) % MOD;
                dp5[i] = (dp5[i-3] + diff) % MOD;
                dp[i] = (dp[i] + dp5[i]) % MOD;
            }

            if (i - 6 >= 0) {
                long diff = (dp[i - 6] * 4) % MOD;
                dp6[i] = (dp6[i-3] + diff) % MOD;
                dp[i] = (dp[i] + dp6[i]) % MOD;
            }
        }

        return Math.toIntExact(dp[n]);
    }
}