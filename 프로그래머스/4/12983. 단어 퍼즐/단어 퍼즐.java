import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int tLength = t.length();
        int strsLength = strs.length;
        int[] dp = new int[tLength + 1];

        for(int i = 1; i < tLength + 1; i ++) {
            for(int j = 0; j < strsLength; j ++) {
                String word = strs[j];
                int wordLength = word.length();
                if(i - wordLength < 0) continue;

                if(word.equals(t.substring(i - wordLength, i))) {
                    if(i - wordLength == 0) {
                        dp[i] = 1;
                        continue;
                    }
                    if(dp[i - wordLength] > 0) {
                        dp[i] = dp[i] == 0 ? dp[i - wordLength] + 1 : Math.min(dp[i], dp[i - wordLength] + 1);
                    }
                }
            }
        }

        int answer = dp[tLength];
        if (answer == 0) return -1;
        return answer;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new String[]{"ba", "na", "n", "a"}, "banana");
    }
}