import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        //에어컨 키는 것은 무조건 온도 증가 행위임을 나타내기 위해 temp 재설정
        int temp = temperature > t2 ? t1 - (temperature - t2) : temperature;
        int INF = 987654321;
        //외부온도를 0으로 맞춰줌
        t1 -= temp;
        t2 -= temp;
        temp = 0;

        //dp[a][b] : a분에 b온도를 맞추기 위한 최소 비용
        //최대온도는 t2를 초과할 필요가 없음
        int[][] dp = new int[onboard.length][t2 + 2];
        for (int i = 0; i < onboard.length; i++)
            Arrays.fill(dp[i], INF);
        dp[0][0] = 0;
        for (int i = 1; i < onboard.length; i++) {
        	//다음 3가지 케이스 중 하나
            //1. 온도 올리기 (에어컨 가동 -> 비용 a)
            //2. 온도 유지 (에어컨 가동 -> 비룔 b) + (목표온도 = 외부온도 -> 비용 0)
            //3. 온도 하강 (에어컨 끄기 -> 비용 0)
            for (int j = 0; j <= t2 + 1; j++) {
                //탑승중일때 온도 범위 벗어나면 구하지 않음
                if (onboard[i] == 1 && (j < t1 || j > t2)) continue;
                int min = INF;
                //1. 외부온도 == 목표온도
                if (j == 0) {
                    //온도 올리기
                    //온도 유지하기
                    min = Math.min(min, dp[i-1][j]);
                    //온도 내리기
                    if (j + 1 <= t2 + 1) min = Math.min(min, dp[i-1][j+1]);
                }
                //2. 외부온도 != 목표온도
                else {
                    //온도 올리기
                    if (j - 1 >= 0) min = Math.min(min, dp[i-1][j-1] + a);
                    //온도 유지하기
                    min = Math.min(min, dp[i-1][j] + b);
                    //온도 내리기
                    if (j + 1 <= t2 + 1) min = Math.min(min, dp[i-1][j+1]);
                }
                dp[i][j] = min;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j <= t2 + 1; j++)
            result = Math.min(result, dp[onboard.length-1][j]);
        return result;
    }
}