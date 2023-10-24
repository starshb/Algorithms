import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> { return o1[1]-o2[1]; });
        
        int last = -1;
        for (int[] target : targets) {
            if (last == -1) {
                answer++;
                last = target[1] - 1;
                continue;
            }
            
            if (last >= target[0] && last <= target[1]) continue;
            
            answer++;
            last = target[1] - 1;
        }
        
        return answer;
    }
}