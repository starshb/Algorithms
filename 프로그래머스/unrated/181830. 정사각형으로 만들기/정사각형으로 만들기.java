import java.util.*;
class Solution {
    public int[][] solution(int[][] arr) {
        int oneLen = arr.length;
        int twoLen = arr[0].length;
        int[][] answer1 = new int[oneLen][oneLen];
        int[][] answer2 = new int[twoLen][twoLen];
        if(oneLen > twoLen) {
            for(int i =0; i<oneLen; i++) {
                answer1[i] = Arrays.copyOf(arr[i], oneLen);
            }
            return answer1;
        }else if(twoLen > oneLen) {
            for(int i =0; i<oneLen; i++) {
                answer2[i] = Arrays.copyOf(arr[i], twoLen);
            }
            return answer2;
        }
        return arr;
    }
}