class Solution {
    public int solution(int[][] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return 0; // 조건을 만족하지 않으면 0을 반환
                }
            }
        }

        return 1; // 모든 조건을 만족하면 1을 반환
    }
}