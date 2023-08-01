import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, Integer.MAX_VALUE);
        
        for (int j = 0; j < queries.length; j++) {
            for (int i = queries[j][0]; i <= queries[j][1]; i++) {
                if (arr[i] > queries[j][2]) {
                    answer[j] = Math.min(answer[j], arr[i]);
                }
            }
            if (answer[j] == Integer.MAX_VALUE) answer[j] = -1;
        }
        return answer;
    }
}