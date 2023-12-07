import java.util.*;
import java.lang.*;
class Solution {
    int[][] array;
    String answer = null;
    StringBuilder route;
    char[] dir = {'d', 'l', 'r', 'u'};
    int[] rdir = {1, 0, 0, -1};
    int[] cdir = {0, -1, 1, 0};
    int endRow, endCol;
    int arrRow, arrCol; //미로 길이
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        route = new StringBuilder();
        array = new int[n][m];
        endRow = r; endCol = c;
        arrRow = n; arrCol = m;
        //최단거리 계산 - 거리 k로 갈 수 있는지 여부
        int length = distance(x, y, r, c);
        if((k - length) % 2 == 1 || k < length) return "impossible";
        dfs(x, y, 0, k);
        
        return answer == null ? "impossible" : answer;
    }

    private int distance(int x, int y, int r, int c){
        return (int)Math.abs(x-r) + (int)Math.abs(y-c);
    }

    private void dfs(int r, int c, int depth, int k){
        
        if(answer != null) return;
        if(depth + distance(r, c, endRow, endCol) > k) return; //현재 깊이 + 남은 거리 > k
        if(k == depth) {
            answer = route.toString();
            return;
        }
        for(int i=0; i<4; i++){
            
            int nextRow = r + rdir[i];
            int nextCol = c + cdir[i];
            if(nextRow <= arrRow && nextCol <= arrCol && nextRow > 0 && nextCol >0){
                route.append(dir[i]);
                dfs(nextRow, nextCol, depth+1, k);
                route.delete(depth, depth+1);
            }
            
        }

    }
}