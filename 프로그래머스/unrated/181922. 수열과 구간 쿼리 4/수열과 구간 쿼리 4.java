class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];

            if (k == 0) {
                if (s==0) arr[0]++;
                continue;
            }

            int i = s/k*k;
            if (s%k != 0) i+=k;

            while (i <= e) {
                arr[i]++;
                i+=k;
            }
        }

        return arr;
    }
}