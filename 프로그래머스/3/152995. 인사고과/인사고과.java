import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] wanho = scores[0];
        Arrays.sort(scores, new Comparator<int[]>(){
           @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0])
                    return 1;
                else if(o1[0] == o2[0]) {
                    if(o1[1] > o2[1])
                        return 1;
                    else
                        return -1;
                }
                else return -1;
            }
        });
        int myPoint = wanho[0] + wanho[1];
        int peerPoint = 0;
        for(int[] score : scores) {
            if(score[1] < peerPoint) {
                if(wanho[0] == score[0] && wanho[1] == score[1])
                    return -1;
            }
            else {
                peerPoint = Math.max(score[1], peerPoint);
                if(myPoint < score[0] + score[1])
                    answer++;
            }
        }
        return answer;
    }
}