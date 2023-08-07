import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] interval1 = Arrays.copyOfRange(arr, intervals[0][0], intervals[0][1] + 1);
        int[] interval2 = Arrays.copyOfRange(arr, intervals[1][0], intervals[1][1] + 1);

        int[] answer = new int[interval1.length + interval2.length];

        System.arraycopy(interval1, 0, answer, 0, interval1.length);
        System.arraycopy(interval2, 0, answer, interval1.length, interval2.length);

        return answer;
    }
}