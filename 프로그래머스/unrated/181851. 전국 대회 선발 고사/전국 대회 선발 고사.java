import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[][] rankIndex = new int[rank.length][2];

        for (int i = 0; i < rank.length; i++) {
            rankIndex[i][0] = rank[i];
            rankIndex[i][1] = i;
        }
        
        Arrays.sort(rankIndex, (a, b) -> a[0] - b[0]);
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[rankIndex[i][1]]) {
                result.add(rankIndex[i][1]);
            }
            if (result.size() == 3) {
                break;
            }
        }
        
        return 10000 * result.get(0) + 100 * result.get(1) + result.get(2);
    }
}