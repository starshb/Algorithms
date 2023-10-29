import java.util.*;

class Solution {
    int len;
    public long solution(int[] w) {
        long answer = 0;
        len = w.length;
        Arrays.sort(w);
        int prev  =0 ;
        for(int i =0 ;i <len-1;i++){
            if(i > 0 && w[i] == w[i-1]){
                prev--;
                answer+=prev;
                continue;
            }
            int j = findRignt(w,w[i], i+1);
            prev = 0;
            for(; j > i ;j --){
                if(w[i] == w[j] ||w[i] * 2== w[j] 
                   || w[i] * 3 == w[j] * 2 || w[i] * 4 == w[j] * 3){
                    prev++;
                }
            }
            answer+=prev;
        }
        return answer;
    }
    public int findRignt(int[]w, int num, int i){
        int left = i;
        int right = len-1;
        while(left < right){
            int mid = left +(right-left)/2;
            if(w[mid] > num*2)return mid;
            else left = mid+1;
        }
        return left;
    }
}