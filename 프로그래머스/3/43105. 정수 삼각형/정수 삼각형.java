import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length; // 삼각형 높이
        
        int[][] dp = new int[height][height]; // 합 기록할 배열
        
        // 가장 왼쪽 단계는 미리 저장
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < height; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
        }
        
        // 위에서부터 높이 하나씩 내려가면서 최대값 구하기
        for(int i = 1; i < height; i++) {
            for(int j = 1; j < triangle[i].length; j++) {
            	// 왼쪽 위에서 내려와 더했을 때, 오른쪽 위에서 내려와 더했을 때 중 최대값 저장
                dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
            }
        }
        
        // 삼각형의 바닥에서 가장 큰 값 구하기
        for(int i = 0; i < height; i++) {
            answer = Math.max(dp[height - 1][i], answer);
        }
        
        return answer;
    }
}