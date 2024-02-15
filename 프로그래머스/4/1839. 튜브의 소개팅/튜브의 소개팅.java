import java.util.*;

class Solution {

    public class Point implements Comparable<Point>{
        int x, y, d, s;

        public Point(int x, int y, int d, int s) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;
        }

        @Override
        public int compareTo(Point o) {
            return this.s - o.s;
        }
    }

    public int[] solution(int m, int n, int s, int[][] time_map) {
        //초기화
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int[][] chk = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(chk[i], Integer.MAX_VALUE);
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(0,0,0,0));

        int[] result = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == m-1 && cur.y == n-1) {
                if (cur.d < result[0]
                        || (cur.d == result[0] && cur.s < result[1])) {
                    result[0] = cur.d;
                    result[1] = cur.s;
                }
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int X = cur.x + dx[d];
                int Y = cur.y + dy[d];
                if (X < 0 || Y < 0 || X >= m || Y >= n) continue;
                if (time_map[X][Y] == -1) continue;
                int newD = cur.d + 1;
                long newS = (long)cur.s + (long)time_map[X][Y];
                //제한 시간 넘기는지 확인
                if (newS > s) continue;
                //최소 거리보다 작거나 큰지 확인 
                if (chk[X][Y] <= newD) continue;
                chk[X][Y] = newD;
                q.add(new Point(X, Y, newD, Math.toIntExact(newS)));
            }
        }
        return result;
    }
}