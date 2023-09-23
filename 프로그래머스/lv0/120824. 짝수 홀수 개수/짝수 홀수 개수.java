class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;

        for(int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) {
                left++;
            }
            else {
                right++;
            }
        }

        answer[0] = left;
        answer[1] = right;

        return answer;
    }
}