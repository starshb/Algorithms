class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            if (arr.length % 2 == 1 && i % 2 == 0) {
                answer[i] = arr[i] + n;
            } else if (arr.length % 2 == 0 && i % 2 == 1) {
                answer[i] = arr[i] + n;
            } else {
                answer[i] = arr[i];
            }
        }
        
        return answer;
    }
}