import java.util.Arrays;

public class Solution {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int len = A.length - 1;
        int index = len;

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=len; i>=0; i--) {
            if(B[index] > A[i]) {
                answer++;
                index--;
            }
        }
        return answer;
    }
}