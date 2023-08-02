class Solution {
    public int[] solution(int start, int end) {
        int size = end - start + 1;
        int[] answer = new int[size];
        
        for (int i = 0; i < size; i++) {
            answer[i] = start++;
        }
        
        return answer;
    }
}