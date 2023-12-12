import java.util.Arrays;

class Solution {
    public int R, C;
    public int[][] M, T, tmp;

    public void flipCol(int c) {
        for (int i = 0; i < R; i++)
            tmp[i][c] = tmp[i][c] == 0 ? 1 : 0;
    }

    public void copyArr() {
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                tmp[i][j] = M[i][j];
    }


    public int solution(int[][] beginning, int[][] target) {
        R = beginning.length;
        C = beginning[0].length;
        M = beginning;
        T = target;
        tmp = new int[R][C];
        int result = Integer.MAX_VALUE;
        //모든 열에 대해서 반복
        for (int mask = 0; mask < 2 << C; mask++) {
            int tmpResult = 0;
            copyArr();
            //1. 칼럼 뒤집기
            for (int col = 0; col < C; col++) {
                //뒤집지 않는 열의 경우 냅둠
                if ((mask & 2 << col) == 0) continue;
                tmpResult++;
                flipCol(col);
            }
            //2. 모든 로우 판별
            boolean flag = false;
            for (int i = 0; i < R; i++) {
                if (flag) break;
                //안뒤집어져 있으면
                if (tmp[i][0] == T[i][0]) {
                    for (int j = 1; j < C; j++) {
                        if (tmp[i][j] != T[i][j]){
                            flag = true;
                            break;
                        }
                    }
                }
                //뒤집어져 있으면
                else {
                    for (int j = 1; j < C; j++) {
                        if (tmp[i][j] == T[i][j]){
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) tmpResult++;
                }
            }
            //일치하는 경우
            if (!flag) result = Math.min(result, tmpResult);
        }
        if (result == Integer.MAX_VALUE) return -1;
        else return result;
    }
}