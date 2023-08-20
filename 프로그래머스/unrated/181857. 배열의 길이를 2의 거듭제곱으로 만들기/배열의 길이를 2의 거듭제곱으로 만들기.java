import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        int targetLength = 1;
        
        // targetLength가 n보다 작거나 같은 2의 거듭제곱을 찾음
        while (targetLength < n) {
            targetLength *= 2;
        }
        
        // 0을 추가하여 targetLength 길이의 배열 생성
        int[] answer = new int[targetLength];
        Arrays.fill(answer, 0);
        
        // arr의 요소들을 answer로 복사
        System.arraycopy(arr, 0, answer, 0, n);
        
        return answer;
    }
}