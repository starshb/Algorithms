class Solution {
    public int solution(int[] num_list) {
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) { // 짝수 인덱스
                evenSum += num_list[i];
            } else { // 홀수 인덱스
                oddSum += num_list[i];
            }
        }

        return (oddSum > evenSum) ? oddSum : evenSum;
    }
}