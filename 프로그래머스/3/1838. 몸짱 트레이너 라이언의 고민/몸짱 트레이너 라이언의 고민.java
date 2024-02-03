import java.util.*;

class Solution {

    public class Point {
        int x, y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int n, int m, int[][] timetable) {
        //초기화
        // 600 ~ 1321 까지 가능한 배열
        int[] preSum = new int[722];

        //1. 가장 많이 겹치는 회원수 구하기
        for (int i = 0; i < m; i++) {
            preSum[timetable[i][0] - 600]++;
            preSum[timetable[i][1] - 600 + 1]--;
        }

        int sum = 0;
        int max = 0; //가장 많이 겹치는 회원 수
        for (int i = 0; i <= 720; i++) {
            sum += preSum[i];
            preSum[i] = sum;
            max = Math.max(max, preSum[i]);
        }

        if (max <= 1) return 0;

        //2. 가능한 거리 순회하며 max만큼 배치할 수 있으면 리턴
        ArrayList<Point> list = new ArrayList<>();
        for (int dist = 2 * (n - 1); dist >= 1; dist--) {
        
        	//첫번쨰 row의 시작지점을 변경 
            for (int sy = 0; sy < n; sy++) {
                list.clear();
                int cnt = 0;
                //맵 전체 순회
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        
                        if (i == 0 && j < sy) continue;
                        
                        //해당 위치에 회원 들어갈 수 있는지 확인
                        boolean flag = true;
                        for (Point p : list) {
                            if (Math.abs(p.x - i) + Math.abs(p.y - j) >= dist)
                                continue;
                            flag = false;
                            break;
                        }
                        if (flag) {
                            if (++cnt == max)
                                return dist;
                            list.add(new Point(i, j));
                        }
                    }
                }
            }
        }
        return 0;
    }
}