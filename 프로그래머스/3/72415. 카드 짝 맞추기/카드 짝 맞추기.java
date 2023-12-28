import java.util.*;

class Solution {
    public class Point {
        int x, y, t;

        public Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public int totalCnt = 0, result = Integer.MAX_VALUE;
    public boolean[] existChk = new boolean[7];
    public Point[][] cardPos = new Point[7][2];
    public int[][] map;

    //최소 이동 거리 계산
    public int bfs(int sx, int sy, int tx, int ty) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] chk = new boolean[4][4];
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        q.add(new Point(sx, sy, 0));
        chk[sx][sy] = true;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == tx && cur.y == ty)
                return cur.t;
            //1. 4반향 1칸씩 계산
            for (int d = 0; d < 4; d++) {
                int X = cur.x + dx[d];
                int Y = cur.y + dy[d];
                if (X < 0 || Y < 0 || X >= 4 || Y >= 4 || chk[X][Y]) continue;
                chk[X][Y] = true;
                q.add(new Point(X, Y, cur.t + 1));
            }
            //2. 4반향 ctrl 이동 계산
            for (int d = 0; d < 4; d++) {
                int X = cur.x, Y = cur.y;
                while(true) {
                    X += dx[d];
                    Y += dy[d];
                    //범위 초과했으면
                    if (X == 4 || Y == 4 || X == -1 || Y == -1) {
                        X -= dx[d];
                        Y -= dy[d];
                        break;
                    }
                    //특정 카드를 만났으면
                    if (map[X][Y] != 0)
                        break;
                }
                if (chk[X][Y]) continue;
                chk[X][Y] = true;
                q.add(new Point(X, Y, cur.t + 1));
            }
        }
        return -1;
    }

    //카드 제거 순서 순열
    public void dfs(int ind, int tmpRes, int r, int c) {
        //결과 비교
        if (ind == totalCnt) {
            result = Math.min(result, tmpRes);
            return;
        }

        //진행
        for (int i = 1; i <= 6; i++) {
            if (!existChk[i]) continue;
            //최소 이동 거리 계산 아래 두 케이스 비교
            //1. 현재 위치 -> 첫번쨰 위치 (+엔터) -> 두번째 위치 (+엔터)
            //2. 현재 위치 -> 두번째 위치 (+엔터) -> 첫번쨰 위치 (+엔터)
            int moveCnt1 = bfs(r, c, cardPos[i][0].x, cardPos[i][0].y) + bfs(cardPos[i][0].x, cardPos[i][0].y, cardPos[i][1].x, cardPos[i][1].y) + 2;
            int moveCnt2 = bfs(r, c, cardPos[i][1].x, cardPos[i][1].y) + bfs(cardPos[i][1].x, cardPos[i][1].y, cardPos[i][0].x, cardPos[i][0].y) + 2;

            //다음 dfs 진행
            existChk[i] = false;
            map[cardPos[i][0].x][cardPos[i][0].y] = 0;
            map[cardPos[i][1].x][cardPos[i][1].y] = 0;
            if (moveCnt1 < moveCnt2) dfs(ind + 1, tmpRes + moveCnt1, cardPos[i][1].x, cardPos[i][1].y);
            else dfs(ind + 1, tmpRes + moveCnt2, cardPos[i][0].x, cardPos[i][0].y);
            map[cardPos[i][0].x][cardPos[i][0].y] = i;
            map[cardPos[i][1].x][cardPos[i][1].y] = i;;
            existChk[i] = true;
        }
    }

    public int solution(int[][] board, int r, int c) {
        //초기화
        map = board;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 0) continue;
                //카드 종류 추가
                if (!existChk[map[i][j]]) {
                    existChk[map[i][j]] = true;
                    totalCnt++;
                    cardPos[map[i][j]][0] = new Point(i, j, 0);
                } else {
                    cardPos[map[i][j]][1] = new Point(i, j, 0);
                }
            }
        }

        //결과 계산
        dfs(0, 0, r, c);
        return result;
    }
}