class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = 100000;
        int answer = 0;

        while (start <= end) {
            int level = (start + end)/2;
            long totalTime = getTotalTime(diffs, times, level);

            if (totalTime <= limit) {
                answer = level;
                end = level - 1;
            } else {
                start = level + 1;
            }
        }

        return answer;
    }
    
    private long getTotalTime(int[] diffs, int[] times, int level) {
        long totalTime  = 0;

        for (int i = 0; i < diffs.length; i++) {
            int solveTimes = diffs[i] - level;

            if (solveTimes <= 0) {
                totalTime += times[i];
                continue;
            }

            if (i == 0) {
                totalTime += (long) times[i] * solveTimes + times[i];
            } else {
                totalTime += (long) (times[i - 1] + times[i]) * solveTimes + times[i];
            }
        }
        return totalTime;
    }
}
