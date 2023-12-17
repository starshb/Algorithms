import java.io.*;
 
class Solution {
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N, M;
    static int MAX = 987654321;
 
    static class turn {
        boolean isWin;
        int cnt;
 
        turn(boolean isWin, int cnt) {
            this.cnt = cnt;
            this.isWin = isWin;
        }
    }
 
    public static int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;
 
        turn res = dfs(board, aloc, bloc, true, 0);
 
        return res.cnt;
    }
 
    private static turn dfs(int[][] board, int[] aloc, int[] bloc, boolean isATurn, int cnt) {
        int ay = aloc[0];
        int ax = aloc[1];
        int by = bloc[0];
        int bx = bloc[1];
 
        if ((board[ay][ax] == 0 && isATurn) || (board[by][bx] == 0 && !isATurn))
            return new turn(false, cnt);
 
        int win = MAX;
        int lose = 0;
        int y, x;
        if (isATurn) {
            y = ay;
            x = ax;
        } else {
            y = by;
            x = bx;
        }
        board[y][x] = 0;
 
        turn res = null;
        boolean canGo = false;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
 
            if ((ny < 0 || nx < 0 || ny >= N || nx >= M) || board[ny][nx] == 0) continue;
            canGo = true;
            if (isATurn) {
                res = dfs(board, new int[]{ny, nx}, bloc, !isATurn, cnt + 1);
            } else {
                res = dfs(board, aloc, new int[]{ny, nx}, !isATurn, cnt + 1);
            }
 
            // 다음 순번이 이길 경우 현재 순번이 패배 -> 최대의 움직임
            if (res.isWin) {
                lose = Math.max(lose, res.cnt);
            }
            // 다음 순번이 질 경우 현재 순번이 승리 -> 최소의 움직임
            else {
                win = Math.min(win, res.cnt);
            }
        }
 
        board[y][x] = 1;
        // 어떠한 방향으로도 이동 불가
        if (!canGo) {
            return new turn(false, cnt);
        } 
        // 현재 순번이 이기는 경우
        else if (win != MAX) {
            return new turn(true, win);
        } 
        // 현재 순번이 지는 경우
        else {
            return new turn(false, lose);
        }
    }
 
}