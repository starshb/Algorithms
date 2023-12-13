import java.util.*;

class Solution {
    int N, result = Integer.MAX_VALUE;
    int[][] map;
    int[] rot;
    int[] dx = {0,0,0,1,-1};
    int[] dy = {0,1,-1,0,0};

    //첫번째 줄 0~N-1 번째 칼럼의 회전수 정하기
    public void dfs (int ind) {
        //정합성 판별
        if (ind == N) {
            //초기화
            int[][] tmp = new int[N][N];
            int[] cur = new int[N];
            for (int i = 0; i < N; i++)
                cur[i] = rot[i];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    tmp[i][j] = map[i][j];
            }

            int tmpRes = 0;
            //0번째 row부터 마지막 row까지 반복
            for (int i = 0; i < N; i++) {
                //특정 row에 대해 시계 돌려줌
                for (int j = 0; j < N; j++) {
                    tmpRes += cur[j];
                    //4방향+현재 위치 시계 돌려줌
                    for (int d = 0; d < 5; d++) {
                        int X = i + dx[d];
                        int Y = j + dy[d];
                        if (X < 0 || Y < 0 || X >= N || Y >= N) continue;
                        tmp[X][Y] = tmp[X][Y] - cur[j] >= 0 ? tmp[X][Y] - cur[j] : tmp[X][Y] - cur[j] + 4;
                    }
                }

                //다음 row가 돌려야할 횟수
                for (int j = 0; j < N; j++)
                    cur[j] = tmp[i][j];
            }

            //마지막 열의 상태 판별하여 결과 계산
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                if (cur[i] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) result = Math.min(result, tmpRes);
            return;
        }

        //회전수 정하기
        for (int i = 0; i < 4; i++) {
            rot[ind] = i;
            dfs(ind + 1);
        }
    }

    public int solution(int[][] clockHands) {
        //초기화
        N = clockHands.length;
        map = new int[N][N];
        rot = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i][j] = 4 - clockHands[i][j] == 4 ? 0 : 4-clockHands[i][j];
        }

        //dfs 진행
        dfs (0);
        return result;
    }
}