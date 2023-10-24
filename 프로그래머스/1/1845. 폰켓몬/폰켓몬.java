class Solution {
    public int solution(int[] nums) {
        int[] counts = new int[200001];
        int answer = 0;
        for(int i = 0; i < nums.length; i++) {
            if(counts[nums[i]] == 0) {
                answer++;
            }
            counts[nums[i]]++;
        }
        if(answer > nums.length / 2) {
            answer = nums.length / 2;
        }
        return answer;
    }
}